package de.drjonah.advgames.listener;

import de.drjonah.advgames.Main;
import de.drjonah.advgames.spectate.SpectateManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class DeathListener implements Listener {

    SpectateManager manager = Main.getInstance().getSpectateManager();
    private int deaths = 0;

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        event.getEntity().addScoreboardTag("dead");
        event.setDeathMessage("");
        if (event.getEntity().getKiller() != null) {
            Bukkit.broadcastMessage(Main.PREFIX + "Der Spieler §b" + event.getEntity().getName() + "§7 wurde von §b" + event.getEntity().getKiller() +
                    "§7 getötet!");

            for (Player p : Bukkit.getOnlinePlayers()) {
                if (p.getScoreboardTags().contains("dead")) {
                    deaths++;
                }
                // klar die Spieler können leaven... aber ja
                if (deaths == Bukkit.getOnlinePlayers().size()) {
                    Bukkit.broadcastMessage(Main.PREFIX + "Der Spieler §9" + event.getEntity().getKiller() + "§7 hat das Spiel §agewonnen§7! \n" +
                            "Herzlichen Glückwunsch :D");
                }
            }

            deaths = 0;
        }
    }


    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        // spec "starten"
        manager.addSpectator(event.getPlayer());
        event.getPlayer().teleport(event.getPlayer().getWorld().getSpawnLocation());
    }
}
