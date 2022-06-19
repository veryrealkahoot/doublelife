package net.rypixel.doublelife;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Inventories {

    public static Inventory getSettingsMenu() {
        Inventory inv = Bukkit.createInventory(null, 9, "Settings");

        ArrayList<String> lore = new ArrayList<>();

        lore.add("Toggles showing the");
        lore.add("player who their");
        lore.add("soulmate is");
        lore.add("");
        inv.setItem(0, getItem(Material.BOOK, "Show Soulmate Name", GameData.tellSoulmate, lore));
        lore.clear();

        lore.add("Toggles showing all");
        lore.add("the soulmate pairs in");
        lore.add("the game chat");
        inv.setItem(1, getItem(Material.GOAT_HORN, "Announce Soulmate Name", GameData.announceSoulmate, lore));
        lore.clear();

        lore.add("Disables crafting enchantment");
        lore.add("tables");
        lore.add("(For servers that have");
        lore.add("only one enchanting table)");
        inv.setItem(2, getItem(Material.ENCHANTING_TABLE, "Uncraftable Enchating Table", GameData.canCraftEnchantingTableStatic, lore));
        lore.clear();

        lore.add("Manage the amount of");
        lore.add("starting lives each");
        lore.add("team has");
        inv.setItem(2, getItem(Material.NETHER_STAR, "Manage Lives", lore));
        lore.clear();

        return inv;
    }

    public static Inventory getLifeCountManager() {
        Inventory inv = Bukkit.createInventory(null, 9, "Settings - Life Count");

        ArrayList<String> lore = new ArrayList<>();

        lore.add("Decrease the starting");
        lore.add("life count");
        inv.setItem(4, getItem(Material.COAL, "Decrease", lore));
        lore.clear();

        if (GameData.startingLives == 1) {
            inv.setItem(5, getItem(Material.NETHER_STAR, GameData.startingLives + " Life", lore));
        } else {
            inv.setItem(5, getItem(Material.NETHER_STAR, GameData.startingLives + " Lives", lore));
        }

        lore.add("Increase the starting");
        lore.add("life count");
        inv.setItem(6, getItem(Material.DIAMOND, "Increase", lore));
        lore.clear();

        inv.setItem(6, getItem(Material.ARROW, "Back", lore));
        lore.clear();

        return inv;
    }

    public static ItemStack getItem(Material material, String name, boolean isSelected, ArrayList<String> oldLore) {
        ArrayList<String> lore = new ArrayList<>();
        for (String str : oldLore) {
            lore.add(ChatColor.WHITE + str);
        }
        lore.add("");
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + name);
        if (isSelected) {
            meta.addEnchant(Enchantment.BINDING_CURSE, 1, true);
            lore.add(ChatColor.GREEN + "Enabled: True");
        } else {
            lore.add(ChatColor.RED + "Enabled: False");
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getItem(Material material, String name, ArrayList<String> oldLore) {
        ArrayList<String> lore = new ArrayList<>();
        for (String str : oldLore) {
            lore.add(ChatColor.WHITE + str);
        }
        lore.add("");
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}
