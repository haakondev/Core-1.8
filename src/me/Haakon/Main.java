package me.Haakon;


import me.Haakon.Commands.*;
import me.Haakon.Commands.Gamemodes.*;
import me.Haakon.Listeners.JoinListener;
import me.Haakon.Listeners.QuitListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {


        // Register events
        //getServer().getPluginManager().registerEvents(new CLASS_NAME, this);
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new QuitListener(), this);


        // Register commands
        // this.getCommand("CMD_NAME").setExecutor(new CLASS_NAME);
        this.getCommand("broadcast").setExecutor(new BroadcastCommand());
        this.getCommand("gamemodeselector").setExecutor(new GamemodeSelector());
        this.getCommand("gmc").setExecutor(new GamemodeCreativeCommand());
        this.getCommand("gms").setExecutor(new GamemodeSurvivalCommand());
        this.getCommand("gmsp").setExecutor(new GamemodeSpectatorCommand());
        this.getCommand("gma").setExecutor(new GamemodeAdventureCommand());
        this.getCommand("fly").setExecutor(new FlyCommand());
        this.getCommand("vanish").setExecutor(new VanishCommand());


        Bukkit.getConsoleSender().sendMessage("§8§m-----------------------------");
        Bukkit.getConsoleSender().sendMessage("  §aCore Successfully Reloaded   ");
        Bukkit.getConsoleSender().sendMessage("         §fCoded by Håkon        ");
        Bukkit.getConsoleSender().sendMessage("§8§m-----------------------------");
    }
}
