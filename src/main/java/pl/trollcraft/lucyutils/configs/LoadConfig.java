package pl.trollcraft.lucyutils.configs;

import org.bukkit.configuration.file.YamlConfiguration;
import pl.trollcraft.lucyutils.ConfigsStorages.HelpStorage;
import pl.trollcraft.lucyutils.ConfigsStorages.MessageStorage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LoadConfig {

    public static void reloadAll(){
        LoadConfig.loadHelp();
        LoadConfig.loadMessages();
    }

    public static void loadHelp(){
        YamlConfiguration configuration = Configs.load("commands.yml");

        assert configuration != null;

        HelpStorage.command.clear();
        HelpStorage.label.clear();
        HelpStorage.aliases.clear();
        HelpStorage.description.clear();
        HelpStorage.permission.clear();
        HelpStorage.enabled.clear();
        for( String label : configuration.getConfigurationSection("commands").getKeys(false)) {
            for( String name : configuration.getConfigurationSection("commands." + label).getKeys(false)){
                ArrayList<String> aliases = (ArrayList<String>) configuration.getStringList("commands." + label + "." + name + ".aliases");
                String description = configuration.getString("commands." + label + "." + name + ".description");
                String permission = configuration.getString("commands." + label + "." + name + ".permission");
                Boolean enabled = configuration.getBoolean("commands." + label + "." + name + ".enabled");


                HelpStorage.command.add(name);
                HelpStorage.label.put(name, label);
                HelpStorage.aliases.put(name, aliases);
                HelpStorage.description.put(name, description);
                HelpStorage.permission.put(name, permission);
                HelpStorage.enabled.put(name, enabled);
            }
        }




    }

    public static void loadMessages(){
        YamlConfiguration configuration = Configs.load("messages.yml");

        MessageStorage.reloadComplete = configuration.getString("reloadComplete");
        MessageStorage.helpHeader = configuration.getString("helpHeader");
        MessageStorage.helpFormat = configuration.getString("helpFormat");
        MessageStorage.helpHover = configuration.getString("helpHover");

    }


















    public static void save(){

        YamlConfiguration configuration = Configs.load("commands.yml");
//
//        configuration.set("reloadComplete", MessageStorage.reloadComplete);
//        configuration.set("Variable", Variable);

        Configs.save(configuration, "commands.yml");
    }


}
