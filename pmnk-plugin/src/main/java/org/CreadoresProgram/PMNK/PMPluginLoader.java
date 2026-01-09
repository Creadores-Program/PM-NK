package org.CreadoresProgram.PMNK;
import cn.nukkit.Nukkit;
import cn.nukkit.Server;
import cn.nukkit.event.plugin.PluginDisableEvent;
import cn.nukkit.event.plugin.PluginEnableEvent;
import cn.nukkit.utils.PluginException;
import cn.nukkit.plugin.*;
import org.yaml.snakeyaml.Yaml;
import java.io.File;
import java.io.FileInputStream;
import java.io.*;
import java.io.InputStream;
import java.util.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import java.nio.charset.StandardCharsets;
import php.runtime.env.CompileScope;
import php.runtime.env.Environment;
import php.runtime.env.Context;
import php.runtime.launcher.Launcher;
import php.runtime.reflection.ModuleEntity;
import php.runtime.reflection.ClassEntity;
import php.runtime.Memory;
import php.runtime.memory.ObjectMemory;
import org.develnext.jphp.json.JsonExtension;
import org.CreadoresProgram.PMNK.Main;
import org.CreadoresProgram.PMNK.PharManager;
public class PMPluginLoader implements PluginLoader{
  private Main plugin;
  private Server server;
  private CompileScope scope;
  private Environment env;
  private Map<String, Map<String, byte[]>> pluginsPM = new HashMap<>();
  private static final Pattern[] FILTERS = new Pattern[]{Pattern.compile("^.+\\.phar$")};
  private static final String[] apiVersion = "3.23.1".split("\\.");
  public PMPluginLoader(Server server){
    this.server = server;
    this.plugin = Main.getInstance();
    this.scope = new CompileScope();
    this.scope.setNativeClassLoader(plugin.getClass().getClassLoader());
    this.scope.registerExtension(new JsonExtension());
    this.scope.registerExtension(new NukkitExtension());
    this.env = new Environment(scope, System.out);
    this.plugin.getLogger().info("§eLoading §bPocketmine§e API...");
    try{
      this.loadPMAPI();
    }catch(Throwable e){
      this.plugin.getLogger().error("Error to load Pocketmine API", e);
    }
  }
  private void loadPMAPI(){
    this.plugin.saveResource("pocketmine-api/PocketMine-MP.phar");
    File pocketmineF = new File(plugin.getDataFolder() + "/pocketmine-api/PocketMine-MP.phar");
    Map<String, byte[]> pmDir = PharManager.readPhar(pocketmineF);
    this.plugin.getLogger().debug("§eLoading pocketmine/Pocketmine.php...");
    this.eval(pmDir.get("pocketmine/Pocketmine.php"), "pocketmine/Pocketmine.php");
    for (Map.Entry<String, byte[]> entry : pmDir.entrySet()) {
      String fileName = entry.getKey();
      if(fileName.equals("pocketmine/VersionInfo.php") || fileName.equals("pocketmine/Pocketmine.php")){
        continue;
      }
      this.plugin.getLogger().debug("§eLoading "+fileName+"...");
      this.eval(entry.getValue(), fileName);
    }
    this.plugin.getLogger().debug("§eLoading pocketmine/VersionInfo.php...");
    this.eval(pmDir.get("pocketmine/VersionInfo.php"), "pocketmine/VersionInfo.php");
    this.eval("<?php\n\\pocketmine\\Server::getInstance()->getLogger()->info('Hola mundoo');", "Unknown.php");
  }
  @Override
  public Plugin loadPlugin(String filename) throws Exception {
    return this.loadPlugin(new File(filename));
  }
  @Override
  public Plugin loadPlugin(File file) throws Exception {
    this.registerPathPlugin(file);
    //no implemented
    return null;
  }
  @Override
  public PluginDescription getPluginDescription(String filename){
    return this.getPluginDescription(new File(filename));
  }
  @Override
  public PluginDescription getPluginDescription(File file){
    this.registerPathPlugin(file);
    Map<String, byte[]> pluginDir = this.pluginsPM.get(file.getAbsolutePath());
    if(!pluginDir.containsKey("plugin.yml")){
      return null;
    }
    Yaml yaml = new Yaml();
    Map<String, Object> pluginYmlPm = yaml.load(new String(pluginDir.get("plugin.yml"), StandardCharsets.UTF_8));
    if(!this.checkCompatibility(((String) pluginYmlPm.get("name")), pluginYmlPm.get("api"), true)){
      return null;
    }
    Map<String, Object> pluginYmlNk = new HashMap<>();
    pluginYmlNk.put("api", Nukkit.API_VERSION);
    pluginYmlNk.put("name", pluginYmlPm.get("name"));
    pluginYmlNk.put("version", pluginYmlPm.get("version"));
    String main = String.valueOf(pluginYmlPm.get("main"));
    if(main.startsWith("pocketmine\\")){
      this.server.getLogger().error("Error: ", new PluginException("Invalid Plugin main, cannot start within the PocketMine namespace"));
      return null;
    }
    pluginYmlNk.put("main", main);
    if(pluginYmlPm.containsKey("commands")){
      pluginYmlNk.put("commands", pluginYmlPm.get("commands"));
    }
    if(pluginYmlPm.containsKey("depend")){
      pluginYmlNk.put("depend", pluginYmlPm.get("depend"));
    }
    if(pluginYmlPm.containsKey("softdepend")){
      pluginYmlNk.put("softdepend", pluginYmlPm.get("softdepend"));
    }
    if(pluginYmlPm.containsKey("loadbefore")){
      pluginYmlNk.put("loadbefore", pluginYmlPm.get("loadbefore"));
    }
    if(pluginYmlPm.containsKey("website")){
      pluginYmlNk.put("website", pluginYmlPm.get("website"));
    }
    if(pluginYmlPm.containsKey("description")){
      pluginYmlNk.put("description", pluginYmlPm.get("description"));
    }
    if(pluginYmlPm.containsKey("prefix")){
      pluginYmlNk.put("prefix", pluginYmlPm.get("prefix"));
    }
    if(pluginYmlPm.containsKey("load")){
      pluginYmlNk.put("load", pluginYmlPm.get("load"));
    }
    if(pluginYmlPm.containsKey("author")){
      pluginYmlNk.put("author", pluginYmlPm.get("author"));
    }
    if(pluginYmlPm.containsKey("authors")){
      pluginYmlNk.put("authors", pluginYmlPm.get("authors"));
    }
    if(pluginYmlPm.containsKey("permissions")){
      pluginYmlNk.put("permissions", pluginYmlPm.get("permissions"));
    }
    return new PluginDescription(pluginYmlNk);
  }
  @SuppressWarnings("unchecked")
  private boolean checkCompatibility(String name, Object api, boolean posibleArray){
    if(api instanceof List && posibleArray){
      return checkCompatibility(name, (List<Object>) api);
    }
    String version = String.valueOf(api);
    try {
      //Check the format: majorVersion.minorVersion.patch
      if (!Pattern.matches("^[0-9]+\\.[0-9]+\\.[0-9]+$", version)) {
        throw new IllegalArgumentException();
      }
    } catch (NullPointerException | IllegalArgumentException e) {
      this.server.getLogger().error(this.server.getLanguage().translateString("nukkit.plugin.loadError", new String[]{name, "Wrong API format"}));
      return false;
    }
    String[] versionArray = version.split("\\.");
    if (!Objects.equals(Integer.valueOf(versionArray[0]), Integer.valueOf(apiVersion[0]))) {
      return false;
    }
    if (Integer.parseInt(versionArray[1]) > Integer.parseInt(apiVersion[1])) {
      return false;
    }
    return true;
  }
  private boolean checkCompatibility(String name, List<Object> apis){
    boolean compatible = false;
    for(Object apiC : apis){
      if(this.checkCompatibility(name, apiC, false)){
        compatible = true;
      }
    }
    return compatible;
  }
  private void registerPathPlugin(File file){
    String absolutePathPlugin = file.getAbsolutePath();
    if(this.pluginsPM.containsKey(absolutePathPlugin)){
      return;
    }
    this.pluginsPM.put(absolutePathPlugin, PharManager.readPhar(file));
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
        this.pluginsPM.remove(((PluginBase) plugin).getFile().getAbsolutePath());
    }
  }
  private void eval(byte[] code, String modulePath){
    try{
      Context context = new Context(new ByteArrayInputStream(code), modulePath, StandardCharsets.UTF_8);
      ModuleEntity module = env.importModule(context);
      module.include(env);
      env.getDefaultBuffer().flush();
    }catch(Throwable e){
      plugin.getLogger().error("Error in php code.", e);
      e.printStackTrace();
    }
  }
  private void eval(String code, String modulePath){
    this.eval(code.getBytes(StandardCharsets.UTF_8), modulePath);
  }
  private ClassEntity getClassPhp(String name){
    return env.fetchClass(name);
  }
  public Environment getEnv(){
    return env;
  }
}
