package de.drjonah.advgames.util;

import de.drjonah.advgames.Main;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class Countdown {

    public int time = 60;
    public boolean running = false;

    public Countdown() {
        run();
    }

    public void run() {
        new BukkitRunnable() {
            @Override
            public void run() {

                if (!running) {
                    return;
                }


                switch (time) {
                    case 60:
                        Bukkit.broadcastMessage(Main.PREFIX + "Die Runde beginnt in §b60 §7Sekunden");
                        break;
                    case 30:
                        Bukkit.broadcastMessage(Main.PREFIX + "Die Runde beginnt in §b30 §7Sekunden");
                        break;
                    case 20:
                        Bukkit.broadcastMessage(Main.PREFIX + "Die Runde beginnt in §b20 §7Sekunden");
                        break;
                    case 10:
                        Bukkit.broadcastMessage(Main.PREFIX + "Die Runde beginnt in §b10 §7Sekunden");
                        break;
                    case 5:
                        Bukkit.broadcastMessage(Main.PREFIX + "Die Runde beginnt in §b5 §7Sekunden");
                        break;
                    case 4:
                        Bukkit.broadcastMessage(Main.PREFIX + "Die Runde beginnt in §b4 §7Sekunden");
                        break;
                    case 3:
                        Bukkit.broadcastMessage(Main.PREFIX + "Die Runde beginnt in §b3 §7Sekunden");
                        break;
                    case 2:
                        Bukkit.broadcastMessage(Main.PREFIX + "Die Runde beginnt in §b2 §7Sekunden");
                        break;
                    case 1:
                        Bukkit.broadcastMessage(Main.PREFIX + "Die Runde beginnt in §beiner §7Sekunde");
                        break;
                    case 0:
                        // start game
                        Bukkit.broadcastMessage(Main.PREFIX + "Die Runde beginnt §bjetzt§7!");
                        running = false;
                        break;
                }

                time--;
            }
        }.runTaskTimer(Main.getInstance(), 20 ,20);
    }
}
