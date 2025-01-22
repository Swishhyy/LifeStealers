package me.swishhyy.lifeStealers.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtils {
    public static ItemStack createHeartItem(String name) {
        ItemStack heart = new ItemStack(Material.HEART_OF_THE_SEA);
        ItemMeta meta = heart.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(name);
            heart.setItemMeta(meta);
        }
        return heart;
    }
}
