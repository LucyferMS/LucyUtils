package pl.trollcraft.lucyutils.ConfigsStorages;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;

import java.util.ArrayList;
import java.util.HashMap;

public class HelpStorage {

    public static ArrayList<String> command = new ArrayList();
    public static HashMap<String, String> label = new HashMap<>();
    public static HashMap<String, ArrayList<String>> aliases = new HashMap<>();
    public static HashMap<String, String> description = new HashMap<>();
    public static HashMap<String, String> permission = new HashMap<>();
    public static HashMap<String, Boolean> enabled = new HashMap<>();

}
