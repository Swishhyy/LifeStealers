package me.swishhyy.lifeStealers.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("lifesteal.admin")) {
            sender.sendMessage("§cYou do not have permission to use this command.");
            return true;
        }

        if (args.length < 2) {
            sender.sendMessage("§cUsage: /lifestealadmin <reset|grantheart> <player>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[1]);
        if (target == null) {
            sender.sendMessage("§cPlayer not found!");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "reset":
                // Reset player stats logic here
                sender.sendMessage("§aReset stats for " + target.getName());
                break;
            case "grantheart":
                // Grant heart logic here
                sender.sendMessage("§aGranted a heart to " + target.getName());
                break;
            default:
                sender.sendMessage("§cUnknown command!");
                break;
        }
        return true;
    }
}
