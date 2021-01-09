package pl.trollcraft.lucyutils.commands;

import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.trollcraft.lucyutils.ConfigsStorages.HelpStorage;
import pl.trollcraft.lucyutils.ConfigsStorages.MessageStorage;
import pl.trollcraft.lucyutils.configs.LoadConfig;
import pl.trollcraft.lucyutils.utils.ChatUtils;
import pl.trollcraft.lucyutils.utils.UtilsFunctions;

public class LucyUtilsCommand implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //======================================Console Support Args===================================================\\

        if(args.length == 0){
            UtilsFunctions.helpShow(sender);
        }
        else if(args.length == 1){
            if(sender.hasPermission("lucyfer.admin")){
                if(args[0].equalsIgnoreCase("reload")){
                    LoadConfig.reloadAll();
                    sender.sendMessage("" + MessageStorage.reloadComplete);
                }
                else if(args[0].equalsIgnoreCase("test")){
                    sender.sendMessage(ChatUtils.color("&2To jest test"));
                }

            }
        }
        //======================================Console Support Args===================================================\\



//==========================================================================================================================\\


        //======================================Console UNSUPPORTED Args===================================================\\
        else if(!(sender instanceof Player)){
            sender.sendMessage(ChatUtils.color("" + "Musisz byc graczem zeby to zrobic!"));
            return true;
        }

        Player player = (Player) sender;

        //======================================Console UNSUPPORTED Args===================================================\\
        return true;
    }
}

