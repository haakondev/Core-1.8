package me.Haakon.Commands;

import com.mysql.jdbc.Buffer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

import static me.Haakon.API.API.*;

public class VanishCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p;
        if (!sender.hasPermission("core.vanish")){
            noperm(sender);
            return true;
        }

        if (args.length >= 1) {

            p = Bukkit.getPlayer(args[0]);

        } else if (!(sender instanceof Player)) {
            sender.sendMessage(tc("&cYou can't do this!"));
            return true;
        } else {
            p = (Player) sender;
        }

        if (p == null) {
            sender.sendMessage(prefix + tc("&c" + args[0] + " is offline!"));
            return true;
        }

        if (Vanish.contains(p.getUniqueId())) {
            Vanish.remove(p.getUniqueId());
            p.sendMessage(prefix + tc("You are &cno longer&7 vanished"));
            if ((Player) sender != p) {
                sender.sendMessage(prefix + tc("You toggled &cOFF&7 " + p.getDisplayName() + "'s vanish"));
            }

            p.setFlying(false);
            p.setAllowFlight(false);
            if (!p.hasPermission("core.vanish")) {

                for (UUID target : Vanish) {
                    p.hidePlayer(Bukkit.getPlayer(target));
                }

            }
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                onlinePlayer.showPlayer(p);
            }

        } else {
            Vanish.add(p.getUniqueId());
            p.sendMessage(prefix + tc("You are &anow&7 vanished"));

            if ((Player) sender != p) {
                sender.sendMessage(prefix + tc("You toggled &aON&7 " + p.getDisplayName() + "'s vanish"));
            }

            p.setAllowFlight(true);
            p.setFlying(true);

            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                p.showPlayer(onlinePlayer);

                if (!onlinePlayer.hasPermission("core.vanish") && !Vanish.contains(onlinePlayer.getUniqueId())) {
                    onlinePlayer.hidePlayer(p);
                }

            }

        }


        return true;
    }
}
