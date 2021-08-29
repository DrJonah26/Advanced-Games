package de.drjonah.advgames.spectate;

import de.drjonah.advgames.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class SpectateManager {

    public ItemStack specItem;
    public Inventory specInv = Bukkit.createInventory(null, 27, "§cKompass");

    public SpectateManager() {
        specItem = new ItemBuilder(Material.COMPASS).setDisplayName("§8§l〣 §c§lKompass").build();
    }

    public ItemStack pHead(Player p) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) head.getItemMeta();


        meta.setOwningPlayer(Bukkit.getPlayer(p.getUniqueId()));
        meta.setLocalizedName(p.getName());
        meta.setDisplayName("§6" + p.getName());


        head.setItemMeta(meta);
        return head;
    }

    public void addSpectator(Player player) {

        // skulls setzen
        for (Player onplayer : Bukkit.getOnlinePlayers()) {
            specInv.addItem(pHead(onplayer));
            Bukkit.broadcastMessage("sd2");
        }

        // item geben
        player.getInventory().clear();
        player.getInventory().setItem(0, specItem);
    }

}
