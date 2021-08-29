package de.drjonah.advgames;

import de.drjonah.advgames.util.Config;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class GameManager {


    Config config = Main.getInstance().getCfg();
    public List<Material> materialList = new ArrayList<>();
    public List<Integer> amountList = new ArrayList<>();

    public GameManager() {

        setDiamondBlocks();
        setItems();
    }

    // set Diamondblocks in World
    public void setDiamondBlocks() {

        Location spawnLocation = Bukkit.getWorlds().get(0).getSpawnLocation();

        for (int i = 0; i < 300; i+=10) {

            for (int j = 0; j < 300; j+=10) {
                if (spawnLocation.getWorld().getBlockAt(spawnLocation.clone().add(j,0,i)).getType() == Material.AIR ||
                        spawnLocation.getWorld().getBlockAt(spawnLocation.clone().add(j,0,i)).getType() == Material.GRASS ||
                        spawnLocation.getWorld().getBlockAt(spawnLocation.clone().add(j,0,i)).getType() == Material.TALL_GRASS) {
                    spawnLocation.getWorld().getBlockAt(spawnLocation.clone().add(j,0,i)).setType(Material.DIAMOND_BLOCK);
                }
            }
        }


    }


    // set Contents
    public void setItems() {

        // item
        ItemStack expBottle = new ItemStack(Material.EXPERIENCE_BOTTLE);
        config.getConfig().set("items." + expBottle.getType().name(), expBottle.getType());
        // amount
        config.getConfig().set("items." + expBottle.getType().name() + ".amount", 8);

        // item
        ItemStack apple = new ItemStack(Material.APPLE);
        config.getConfig().set("items." + apple.getType().name(), apple.getType());
        // amount
        config.getConfig().set("items." + apple.getType().name() + ".amount", 5);

        // item
        ItemStack chicken = new ItemStack(Material.COOKED_CHICKEN);
        config.getConfig().set("items." + chicken.getType().name(), chicken.getType());
        // amount
        config.getConfig().set("items." + chicken.getType().name() + ".amount", 9);

        // item
        ItemStack beef = new ItemStack(Material.COOKED_BEEF);
        config.getConfig().set("items." + beef.getType().name(), beef.getType());
        // amount
        config.getConfig().set("items." + beef.getType().name() + ".amount", 6);

        // item
        ItemStack diaChest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        config.getConfig().set("items." + diaChest.getType().name(), diaChest.getType());
        // amount
        config.getConfig().set("items." + diaChest.getType().name() + ".amount", 1);

        // item
        ItemStack goldenLeggings = new ItemStack(Material.GOLDEN_LEGGINGS);
        config.getConfig().set("items." + goldenLeggings.getType().name(), goldenLeggings.getType());
        // amount
        config.getConfig().set("items." + goldenLeggings.getType().name() + ".amount", 1);

        // item
        ItemStack diaLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        config.getConfig().set("items." + diaLeggings.getType().name(), diaLeggings.getType());
        // amount
        config.getConfig().set("items." + diaLeggings.getType().name() + ".amount", 1);

        // item
        ItemStack ironBoots = new ItemStack(Material.IRON_BOOTS);
        config.getConfig().set("items." + ironBoots.getType().name(), ironBoots.getType());
        // amount
        config.getConfig().set("items." + ironBoots.getType().name() + ".amount", 1);

        // item
        ItemStack chainmailBoots = new ItemStack(Material.CHAINMAIL_BOOTS);
        config.getConfig().set("items." + chainmailBoots.getType().name(), chainmailBoots.getType());
        // amount
        config.getConfig().set("items." + chainmailBoots.getType().name() + ".amount", 1);

        // item
        ItemStack leatherBoots = new ItemStack(Material.LEATHER_BOOTS);
        config.getConfig().set("items." + leatherBoots.getType().name(), leatherBoots.getType());
        // amount
        config.getConfig().set("items." + leatherBoots.getType().name() + ".amount", 1);

        // item
        ItemStack stoneSword = new ItemStack(Material.STONE_SWORD);
        config.getConfig().set("items." + stoneSword.getType().name(), stoneSword.getType());
        // amount
        config.getConfig().set("items." + stoneSword.getType().name() + ".amount", 1);

        // item
        ItemStack ironSword = new ItemStack(Material.IRON_SWORD);
        config.getConfig().set("items." + ironSword.getType().name(), ironSword.getType());
        // amount
        config.getConfig().set("items." + ironSword.getType().name() + ".amount", 1);

        // item
        ItemStack goldenHoe = new ItemStack(Material.GOLDEN_HOE);
        config.getConfig().set("items." + goldenHoe.getType().name(), goldenHoe.getType());
        // amount
        config.getConfig().set("items." + goldenHoe.getType().name() + ".amount", 1);

        // item
        ItemStack craftingTable = new ItemStack(Material.CRAFTING_TABLE);
        config.getConfig().set("items." + craftingTable.getType().name(), craftingTable.getType());
        // amount
        config.getConfig().set("items." + craftingTable.getType().name() + ".amount", 1);

        // item
        ItemStack tnt = new ItemStack(Material.TNT);
        config.getConfig().set("items." + tnt.getType().name(), tnt.getType());
        // amount
        config.getConfig().set("items." + tnt.getType().name() + ".amount", 4);

        // item
        ItemStack regeneration = new ItemStack(Material.SPLASH_POTION);
        PotionMeta meta = (PotionMeta) regeneration.getItemMeta();
        meta.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 90, 1), false);
        regeneration.setItemMeta(meta);
        config.getConfig().set("items." + regeneration.getType().name(), ironSword.getType());
        // amount
        config.getConfig().set("items." + regeneration.getType().name() + ".amount", 1);

        // item
        ItemStack water = new ItemStack(Material.WATER_BUCKET);
        config.getConfig().set("items." + water.getType().name(), water.getType());
        // amount
        config.getConfig().set("items." + water.getType().name() + ".amount", 1);

        // item
        ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
        config.getConfig().set("items." + lava.getType().name(), lava.getType());
        // amount
        config.getConfig().set("items." + lava.getType().name() + ".amount", 1);

        // item
        ItemStack diamondAxe = new ItemStack(Material.DIAMOND_AXE);
        config.getConfig().set("items." + diamondAxe.getType().name(), diamondAxe.getType());
        // amount
        config.getConfig().set("items." + diamondAxe.getType().name() + ".amount", 1);
    }
}
