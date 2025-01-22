package me.swishhyy.lifeStealers.teams;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamManager {
    private final Map<String, Team> teams = new HashMap<>();

    public void createTeam(Player player, String teamName) {
        Team team = new Team(teamName);
        team.addMember(player);
        teams.put(teamName, team);
    }

    public Team getTeam(String teamName) {
        return teams.get(teamName);
    }

    public void joinTeam(Player player, String teamName) {
        Team team = teams.get(teamName);
        if (team != null) {
            team.addMember(player);
        }
    }

    public List<String> getTeamNames() {
        return new ArrayList<>(teams.keySet());
    }
}
