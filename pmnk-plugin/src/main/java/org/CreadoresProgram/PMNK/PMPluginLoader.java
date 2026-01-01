package org.CreadoresProgram.PMNK;
import cn.nukkit.Server;
import cn.nukkit.event.plugin.PluginDisableEvent;
import cn.nukkit.event.plugin.PluginEnableEvent;
import cn.nukkit.plugin.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import java.util.regex.Pattern;
import php.runtime.env.CompileScope;
import php.runtime.env.Environment;
import php.runtime.env.Context;
import php.runtime.launcher.Launcher;
import php.runtime.reflection.ModuleEntity;
import org.CreadoresProgram.PMNK.Main;
public class PMPluginLoader implements PluginLoader{
  private Main plugin;
  private Server server;
  private static final Pattern[] FILTERS = new Pattern[]{Pattern.compile("^.+\\.phar$")};
  public PMPluginLoader(Server server){
    this.server = server;
    this.plugin = Main.getInstance();
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
}
