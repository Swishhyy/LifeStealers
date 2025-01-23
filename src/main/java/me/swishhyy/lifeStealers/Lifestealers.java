package me.swishhyy.lifeStealers;

import org.bukkit.plugin.java.JavaPlugin;

public class Lifestealers extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("LifeSteal Plugin Enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("LifeSteal Plugin Disabled!");
    }
}
