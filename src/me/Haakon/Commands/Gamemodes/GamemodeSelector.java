package me.Haakon.Commands.Gamemodes;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.Haakon.API.API.noperm;
import static me.Haakon.API.API.tc;

public class GamemodeSelector implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {

            sender.sendMessage(tc("&cYou can't do this!"));
            return false;

        }

        if (!sender.hasPermission("core.gamemodeselector") && !sender.hasPermission("core.gamemodes")){
            noperm(sender);
            return false;
        }
        Player p = (Player) sender;
        p.sendMessage(tc("&b&lSelect gamemode"));

        TextComponent gmc = new TextComponent(tc("&71. &bCreative"));
        gmc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/gmc"));
        gmc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(tc("&7Click to set gamemode to &b&lCreative")).create()));
        p.spigot().sendMessage(gmc);

        TextComponent gms = new TextComponent(tc("&72. &bSurvival"));
        gms.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/gms"));
        gms.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(tc("&7Click to set gamemode to &b&lSurvival")).create()));
        p.spigot().sendMessage(gms);

        TextComponent gmsp = new TextComponent(tc("&73. &bSpectator"));
        gmsp.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/gmsp"));
        gmsp.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(tc("&7Click to set gamemode to &b&lSpectator")).create()));
        p.spigot().sendMessage(gmsp);

        TextComponent gma = new TextComponent(tc("&74. &bAdventure"));
        gma.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/gma"));
        gma.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(tc("&7Click to set gamemode to &b&lAdventure")).create()));
        p.spigot().sendMessage(gma);


        return true;
    }
}
