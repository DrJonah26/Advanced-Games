package de.drjonah.advgames.listener;

import de.drjonah.advgames.GameManager;
import de.drjonah.advgames.Main;
import de.drjonah.advgames.spectate.SpectateManager;
import de.drjonah.advgames.util.Config;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class InteractListener implements Listener {

    SpectateManager spectateManager = Main.getInstance().getSpectateManager();
    GameManager game = Main.getInstance().getGameManager();
    Config config = Main.getInstance().getCfg();

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        // Diamondblocks
        if (event.getClickedBlock().getType() == Material.DIAMOND_BLOCK) {

            // falls manuell hinzugefügt
            for (Material material : Material.values()) {
                if (config.getConfig().contains("items." + material.name()) && config.getConfig().contains("items." + material.name() + ".amount")) {
                    game.materialList.add(material);
                }
            }


            // give random item
            Material material = game.materialList.get(new Random().nextInt(game.materialList.size()));
            for (int i = 0; i < config.getConfig().getInt("items." + material.name() + ".amount"); i++) {
                event.getPlayer().getInventory().addItem(new ItemStack(material));
            }
            game.materialList.clear();

            // reset Block
            event.getClickedBlock().setType(Material.AIR);
        }

        // SpecItem
        if(event.getItem().getItemMeta().getDisplayName().equals("§8§l〣 §c§lKompass")) {
            event.getPlayer().openInventory(spectateManager.specInv);
        }

    }
}
