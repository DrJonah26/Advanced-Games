package de.drjonah.advgames.listener;

import de.drjonah.advgames.GameManager;
import de.drjonah.advgames.Main;
import de.drjonah.advgames.util.Config;
import de.drjonah.advgames.util.Countdown;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListeners implements Listener {

    Countdown countdown = Main.getInstance().getCountdown();
    Config config = Main.getInstance().getCfg();
    GameManager game = Main.getInstance().getGameManager();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        event.getPlayer().teleport(Bukkit.getWorlds().get(0).getSpawnLocation());
        if (Bukkit.getOnlinePlayers().size() >= 2) {
            if (!countdown.running) {
                // start Countdown
                countdown.running = true;
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        if (countdown.running) {
            countdown.running = false;
            countdown.time = 60;
            Bukkit.broadcastMessage(Main.PREFIX + "Der Countdown wurde §cabgebrochen§7!");
        }
    }
}
