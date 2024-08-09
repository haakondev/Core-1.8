package me.Haakon.Commands.Gamemodes;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.Haakon.API.API.*;

public class GamemodeSurvivalCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p;

        if (!sender.hasPermission("core.gms") && !sender.hasPermission("core.gamemodes")){
            noperm(sender);
            return true;
        }

        if (args.length >= 1) {
            p = Bukkit.getPlayer(args[1]);
        } else if (!(sender instanceof Player)) {
            sender.sendMessage("&cYou can't do this!");
            return true;
        } else {
            p = (Player) sender;
        }

        if (p == null) {
            sender.sendMessage(prefix + tc("&c" + args[0] + " is offline!"));
            return true;
        }

        p.sendMessage(prefix + tc("Your gamemode has been set to &c&lSURVIVAL"));
        p.setGameMode(GameMode.SURVIVAL);

        return true;

    }

}