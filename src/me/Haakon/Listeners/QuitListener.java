package me.Haakon.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static me.Haakon.API.API.tc;

public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        e.setQuitMessage(tc("&7[&a-&7] &7" + p.getDisplayName() + " has left the server!"));


        p.setFlying(false);
        p.setAllowFlight(false);
    }

}
