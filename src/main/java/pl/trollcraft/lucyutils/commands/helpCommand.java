package pl.trollcraft.lucyutils.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pl.trollcraft.lucyutils.configs.LoadConfig;
import pl.trollcraft.lucyutils.utils.UtilsFunctions;

public class helpCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0){
            UtilsFunctions.helpShow(sender);
        }
        else if(args[0].equalsIgnoreCase("reload")){
            if(sender.hasPermission("help.reload")){
                LoadConfig.loadHelp();
            }
        }


        return true;
    }
}
