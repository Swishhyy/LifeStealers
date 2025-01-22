package me.swishhyy.lifeStealers;

import me.swishhyy.lifeStealers.commands.PlayerCommands;
import me.swishhyy.lifeStealers.teams.TeamManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Lifestealers extends JavaPlugin {
    private TeamManager teamManager;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        teamManager = new TeamManager();

        // Register the PlayerCommands
        PlayerCommands playerCommands = new PlayerCommands(teamManager);
        getCommand("team").setExecutor(playerCommands);
        getCommand("team").setTabCompleter(playerCommands);

        getLogger().info("LifeSteal Plugin Enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("LifeSteal Plugin Disabled!");
    }
}
