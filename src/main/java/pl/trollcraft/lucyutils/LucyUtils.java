package pl.trollcraft.lucyutils;

import org.bukkit.plugin.java.JavaPlugin;
import pl.trollcraft.lucyutils.commands.LucyUtilsCommand;
import pl.trollcraft.lucyutils.commands.ReportCommand;
import pl.trollcraft.lucyutils.configs.LoadConfig;

public class LucyUtils extends JavaPlugin {



    private static LucyUtils plugin;

    public void onEnable(){

        plugin = this;
        getCommand("pomoc").setExecutor(new LucyUtilsCommand());
        getCommand("lucyutils").setExecutor(new LucyUtilsCommand());
        getCommand("report").setExecutor(new ReportCommand());
//        getServer().getPluginManager().registerEvents(new ListenerName(), this);
        LoadConfig.reloadAll();

    }


    public static LucyUtils getPlugin(){
        return plugin;
    }



}
