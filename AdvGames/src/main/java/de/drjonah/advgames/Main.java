package de.drjonah.advgames;

import de.drjonah.advgames.listener.*;
import de.drjonah.advgames.spectate.SpectateManager;
import de.drjonah.advgames.util.Config;
import de.drjonah.advgames.util.Countdown;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private Countdown countdown;
    private static Main instance;
    private GameManager gameManager;
    private Config cfg;
    private SpectateManager spectateManager;

    @Override
    public void onLoad() {
        cfg = new Config();
    }

    @Override
    public void onEnable() {
        instance = this;
        countdown = new Countdown();
        gameManager = new GameManager();
        spectateManager = new SpectateManager();


        Bukkit.getPluginManager().registerEvents(new ConnectionListeners(), this);
        Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new InvClickListener(), this);
        Bukkit.getPluginManager().registerEvents(new BlockListeners(), this);
        Bukkit.getPluginManager().registerEvents(new InteractListener(), this);
    }

    @Override
    public void onDisable() {
        cfg.save();
    }

    public static Main getInstance() {
        return instance;
    }

    public Countdown getCountdown() {
        return countdown;
    }

    public Config getCfg() {
        return cfg;
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    public SpectateManager getSpectateManager() {
        return spectateManager;
    }

    public static final String PREFIX = "§3§lAdvGames §8〣 §7";
}
