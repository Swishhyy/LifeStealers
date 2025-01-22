package me.swishhyy.lifeStealers.commands;

import me.swishhyy.lifeStealers.teams.TeamManager;
import me.swishhyy.lifeStealers.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerCommands implements CommandExecutor, TabCompleter {
    private final TeamManager teamManager;

    public PlayerCommands(TeamManager teamManager) {
        this.teamManager = teamManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            MessageUtils.sendMessage(sender, "&cOnly players can use this command!");
            return true;
        }

        Player player = (Player) sender;

        if (args.length < 1) {
            MessageUtils.sendMessage(player, "&cUsage: /team <create|join> <name>");
            return true;
        }

        String subCommand = args[0].toLowerCase();

        switch (subCommand) {
            case "create":
                if (args.length < 2) {
                    MessageUtils.sendMessage(player, "&cUsage: /team create <name>");
                    return true;
                }
                String teamName = args[1].toLowerCase();
                if (teamManager.getTeam(teamName) != null) {
                    MessageUtils.sendMessage(player, "&cA team with this name already exists!");
                    return true;
                }
                teamManager.createTeam(player, teamName);
                MessageUtils.sendMessage(player, "&aTeam " + teamName + " created!");
                Bukkit.broadcastMessage(player.getName() + " has created a new team: " + teamName);
                break;

            case "join":
                if (args.length < 2) {
                    MessageUtils.sendMessage(player, "&cUsage: /team join <name>");
                    return true;
                }
                String joinTeamName = args[1].toLowerCase();
                if (teamManager.getTeam(joinTeamName) == null) {
                    MessageUtils.sendMessage(player, "&cNo team found with the name " + joinTeamName + "!");
                    return true;
                }
                if (teamManager.getPlayerTeam(player) != null) {
                    MessageUtils.sendMessage(player, "&cYou are already in a team! Leave your current team first.");
                    return true;
                }
                teamManager.joinTeam(player, joinTeamName);
                MessageUtils.sendMessage(player, "&aYou have joined the team " + joinTeamName + "!");
                Bukkit.broadcastMessage(player.getName() + " has joined the team: " + joinTeamName);
                break;

            default:
                MessageUtils.sendMessage(player, "&cUnknown command! Use /team <create|join> <name>.");
                break;
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> suggestions = new ArrayList<>();

        if (args.length == 1) {
            if ("create".startsWith(args[0].toLowerCase())) {
                suggestions.add("create");
            }
            if ("join".startsWith(args[0].toLowerCase())) {
                suggestions.add("join");
            }
        } else if (args.length == 2 && args[0].equalsIgnoreCase("join")) {
            for (String teamName : teamManager.getTeamNames()) {
                if (teamName.toLowerCase().startsWith(args[1].toLowerCase())) {
                    suggestions.add(teamName);
                }
            }
        }

        return suggestions;
    }
}
