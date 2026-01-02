package org.CreadoresProgram.PMNK;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginLoadOrder;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
public class Main extends PluginBase{
    private static Main instance;
    public static Main getInstance(){
        return instance;
    }
    @Override
    public void onLoad(){
        instance = this;
    }
    @Override
    public void onEnable(){
        this.getServer().getPluginManager().registerInterface(PMPluginLoader.class);
        List<String> loaders = new ArrayList<>();
        loaders.add(PMPluginLoader.class.getName());
        this.getServer().getPluginManager().loadPlugins(new File(this.getServer().getPluginPath()), loaders, false);
        this.getServer().enablePlugins(PluginLoadOrder.STARTUP);
    }
}

