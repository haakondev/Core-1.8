package me.Haakon.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

import static me.Haakon.API.API.*;

public class BroadcastCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!sender.hasPermission("core.broadcast")){
            noperm(sender);
            return true;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(tc("&8[&4&lAlert&8] &7"));

        for (int i = 0; i < args.length; i++) sb.append(args[i] + " ");

        Bukkit.broadcastMessage(tc(sb.toString()));

        return true;
    }
}
