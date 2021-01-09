package pl.trollcraft.lucyutils.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatUtils {

    public static String color(String toColor) {
        return toColor.replaceAll("&", String.valueOf(ChatColor.COLOR_CHAR));
    }

    public static void sendMessage(Player player, String message){
        player.sendMessage(color("" + message).
                replaceAll("%player%", player.getName())



        );
    }
    public static void consoleMessage(CommandSender player, String message){
        player.sendMessage(color("" + message).
                replaceAll("%player%", player.getName())



        );
    }

//    sendMessage(Nick, wiadomosc)
}