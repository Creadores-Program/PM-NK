package pocketmine.plugin;

import java.io.File;
import java.io.InputStream;
import pocketmine.ServerPm;
//import pocketmine.utils.ConfigPm;
import php.runtime.env.Environment;
import static php.runtime.annotation.Reflection.*;

@Name("Plugin")
@Namespace("pocketmine\\plugin")
public interface PluginPm /*extends CommandExecutorPm*/{
    @Signature
    void __construct(Environment env, /*PluginLoaderPm loader, */ServerPm server, PluginDescriptionPm description, File dataFolder, File file);

    @Signature
    void onLoad();

    @Signature
    void onEnable();

    @Signature
    boolean isEnabled();

    @Signature
    default void setEnabled(){
        this.setEnabled(true);
    }

    @Signature
    void setEnabled(boolean value);

    @Signature
    void onDisable();

    @Signature
    boolean isDisabled();

    @Signature
    File getDataFolder();

    @Signature
    PluginDescriptionPm getDescription();

    @Signature
    InputStream getResource();

    @Signature
    default boolean saveResource(String fileName){
        return this.saveResource(fileName, false);
    }

    @Signature
    boolean saveResource(String fileName, boolean replace);

    /*@Signature
    SplFileInfo[] getResources();

    @Signature
    ConfigPm getConfig();*/

    @Signature
    void saveConfig();

    @Signature
    boolean saveDefaultConfig();

    @Signature
    void reloadConfig();

    @Signature
    ServerPm getServer();

    @Signature
    String getName();

    /*@Signature
    PluginLoggerPm getLogger();

    @Signature
    PluginLoaderPm getPluginLoader();

    @Signature
    TaskSchedulerPm getScheduler();*/
}