package de.drjonah.advgames.listener;

import de.drjonah.advgames.Main;
import de.drjonah.advgames.spectate.SpectateManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvClickListener implements Listener {

    SpectateManager manager = Main.getInstance().getSpectateManager();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if (event.getCurrentItem() == null) {
            return;
        }

        if (event.getInventory() == manager.specInv) {
            event.setCancelled(true);

            player.teleport(Bukkit.getPlayer(event.getCurrentItem().getItemMeta().getLocalizedName()));
            player.closeInventory();
        }
    }
}
