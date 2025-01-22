package me.swishhyy.lifeStealers.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class HeartDropListener implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        event.getDrops().add(new ItemStack(Material.HEART_OF_THE_SEA)); // Example heart drop
    }
}
