package org.CreadoresProgram.PMNK;
import cn.nukkit.Server;
import cn.nukkit.event.plugin.PluginDisableEvent;
import cn.nukkit.event.plugin.PluginEnableEvent;
import cn.nukkit.plugin.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import java.util.Map;
import java.util.regex.Pattern;
import php.runtime.env.CompileScope;
import php.runtime.env.Environment;
import php.runtime.launcher.Launcher;
import php.runtime.reflection.ModuleEntity;
import php.runtime.reflection.ClassEntity;
import php.runtime.Memory;
import php.runtime.memory.ObjectMemory;
import org.CreadoresProgram.PMNK.Main;
import org.CreadoresProgram.PMNK.PharManager;
public class PMPluginLoader implements PluginLoader{
  private Main plugin;
  private Server server;
  private CompileScope scope;
  private Environment env;
  private static final Pattern[] FILTERS = new Pattern[]{Pattern.compile("^.+\\.phar$")};
  public PMPluginLoader(Server server){
    this.server = server;
    this.plugin = Main.getInstance();
    this.scope = new CompileScope();
    this.scope.setNativeClassLoader(plugin.getClass().getClassLoader());
    this.env = new Environment(scope);
    this.loadPMAPI();
  }
  private void loadPMAPI(){
    this.plugin.saveResource("pocketmine-api/PocketMine-MP.phar");
    File pocketmineF = new File(plugin.getDataFolder() + "/pocketmine-api/PocketMine-MP.phar");
    Map<String, byte[]> pmDir = PharManager.readPhar(pocketmineF);
    for (Map.Entry<String, byte[]> entry : pmDir.entrySet()) {
      String fileName = entry.getKey();
      if(fileName == "pocketmine/VersionInfo.php"){
        continue;
      }
      this.eval(new String(entry.getValue()));
    }
    this.eval(new String(pmDir.get("pocketmine/VersionInfo.php")));
    this.eval("echo 'holaa\\n';\n");
    this.eval("<?php \\pocketmine\\Server->getInstance()->getLogger()->info('Hola mundo');");
  }
  @Override
  public Plugin loadPlugin(String filename) throws Exception {
    return this.loadPlugin(new File(filename));
  }
  @Override
  public Plugin loadPlugin(File file) throws Exception {
    //no implemented
    return null;
  }
  @Override
  public PluginDescription getPluginDescription(String filename){
    return this.getPluginDescription(new File(filename));
  }
  @Override
  public PluginDescription getPluginDescription(File file){
    //no implemented
    return null;
  }
  @Override
  public Pattern[] getPluginFilters(){
    return FILTERS;
  }
  @Override
  public void enablePlugin(Plugin plugin){
    if (plugin instanceof PluginBase && !plugin.isEnabled()) {
        this.server.getLogger().info(this.server.getLanguage().translateString("nukkit.plugin.enable", plugin.getDescription().getFullName()));
        ((PluginBase) plugin).setEnabled(true);
        this.server.getPluginManager().callEvent(new PluginEnableEvent(plugin));
    }
  }
  @Override
  public void disablePlugin(Plugin plugin){
    if (plugin instanceof PluginBase && plugin.isEnabled()) {
        this.server.getLogger().info(this.server.getLanguage().translateString("nukkit.plugin.disable", plugin.getDescription().getFullName()));
        this.server.getServiceManager().cancel(plugin);
        this.server.getPluginManager().callEvent(new PluginDisableEvent(plugin));
        ((PluginBase) plugin).setEnabled(false);
    }
  }
  private void eval(String code){
    try{
      env.eval(code);
      env.flushAll();
    }catch(Throwable e){
      plugin.getLogger().error("Error in php code.", e);
    }
  }
  private ClassEntity getClassPhp(String name){
    return env.fetchClass(name);
  }
  public Environment getEnv(){
    return env;
  }
}
