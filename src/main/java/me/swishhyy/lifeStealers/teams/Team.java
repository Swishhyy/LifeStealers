package me.swishhyy.lifeStealers.teams;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private final String teamName;
    private final List<Player> members;

    public Team(String teamName) {
        this.teamName = teamName;
        this.members = new ArrayList<>();
    }

    public String getTeamName() {
        return teamName;
    }

    public List<Player> getMembers() {
        return members;
    }

    public void addMember(Player player) {
        members.add(player);
    }

    public void removeMember(Player player) {
        members.remove(player);
    }
}
