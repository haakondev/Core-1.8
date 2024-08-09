package me.Haakon.API;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class API {

    public static String prefix = tc("&b&lCore &8┃ &7");
    public static void noperm(CommandSender sender) {
        sender.sendMessage(tc("&b&lCore &8&l┃ &cYou don't have permission to do this!"));
    }

    public static String tc(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

}
