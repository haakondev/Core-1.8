package me.Haakon.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static me.Haakon.API.API.tc;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(tc("&7[&a+&7] &7" + e.getPlayer().getDisplayName() + " has joined the server!"));
    }
}
