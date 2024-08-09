package me.Haakon.Commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.Haakon.API.API.*;

public class FlyCommand implements CommandExecutor {

    public static void fly(Player p) {

        if (p.getAllowFlight() == true) {
            p.sendMessage(prefix + tc("You can no longer fly"));
            p.setFlying(false);
            p.setAllowFlight(false);
        } else {

            p.sendMessage(prefix + tc("You can now fly"));
            p.setAllowFlight(true);
            p.setFlying(true);

        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String labels, String[] args) {
        Player p;
        if (!sender.hasPermission("core.fly")){
            noperm(sender);
            return true;
        }

        if (args.length >= 1) {

            p = Bukkit.getPlayer(args[0]);
        }
        else if (!(sender instanceof Player)) {
            sender.sendMessage(tc("&cYou can't do this!"));
            return true;
        } else {
            p = (Player) sender;
        }

        if (p == null) {
            sender.sendMessage(prefix + tc("&c" + args[0] + " is offline!"));
            return true;
        } else if ((Player) sender != p) {
            sender.sendMessage(prefix + tc("You toggled " + p.getDisplayName() + "'s fly ability"));
        }

        fly(p);

        return true;
    }
}
