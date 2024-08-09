package me.Haakon;


import me.Haakon.Commands.BroadcastCommand;
import me.Haakon.Listeners.JoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {


        // Register events
        //getServer().getPluginManager().registerEvents(new CLASS_NAME, this);
        getServer().getPluginManager().registerEvents(new JoinListener(), this);


        // Register commands
        // this.getCommand("CMD_NAME").setExecutor(new CLASS_NAME);
        this.getCommand("broadcast").setExecutor(new BroadcastCommand());

        Bukkit.getConsoleSender().sendMessage("§8§m-----------------------------");
        Bukkit.getConsoleSender().sendMessage("  §aCore Successfully Reloaded   ");
        Bukkit.getConsoleSender().sendMessage("         §fCoded by Håkon        ");
        Bukkit.getConsoleSender().sendMessage("§8§m-----------------------------");
    }
}
