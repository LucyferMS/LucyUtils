package pl.trollcraft.lucyutils.utils;


import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.CommandSender;
import pl.trollcraft.lucyutils.ConfigsStorages.HelpStorage;
import pl.trollcraft.lucyutils.ConfigsStorages.MessageStorage;
import scala.Int;

import javax.xml.soap.Text;
import java.awt.*;

public class UtilsFunctions {


    public static void helpShow(CommandSender sender){
        sender.sendMessage("" + MessageStorage.helpHeader);
        for( String index : HelpStorage.command){

            String command = index;
            String label = HelpStorage.label.get(index);
            String alias = "";
            String aliases = "";
            Integer check = 0;
            for(String a : HelpStorage.aliases.get(index)){
                if(check == 0){
                    alias = a;
                    check++;
                }
                else if(check == 1){
                    aliases += a;
                    check++;
                }
                else{
                    aliases += ", " + a;
                }
            }
            String permission = HelpStorage.permission.get(index);
            Boolean enabled = HelpStorage.enabled.get(index);
            String description = HelpStorage.description.get(index);
//            sender.sendMessage("==============================================================");
            String helpText = ChatUtils.color("" + MessageStorage.helpFormat).
                    replaceAll("%label%", label).
                    replaceAll("%command%", index).
                    replaceAll("%alias%", alias).
                    replaceAll("%aliases%", aliases).
                    replaceAll("%permission%", permission).
                    replaceAll("%enabled%", enabled.toString()).
                    replaceAll("%description%", description);
//            sender.sendMessage(helpText);
//            sender.sendMessage("==============================================================");
            String hoverInfo = ChatUtils.color("" + MessageStorage.helpHover).
                    replaceAll("%label%", label).
                    replaceAll("%command%", index).
                    replaceAll("%alias%", alias).
                    replaceAll("%aliases%", aliases).
                    replaceAll("%permission%", permission).
                    replaceAll("%enabled%", enabled.toString()).
                    replaceAll("%description%", description);
//            sender.sendMessage("==============================================================");
            TextComponent helpHover = new TextComponent( ChatUtils.color(helpText) );
            if(sender.hasPermission("lucyutils.getpermissions")) {
                helpHover.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(hoverInfo).create()));
            }
            if(sender.hasPermission("" + permission) && enabled){
                sender.spigot().sendMessage( helpHover );
            }

        }
    }



}
