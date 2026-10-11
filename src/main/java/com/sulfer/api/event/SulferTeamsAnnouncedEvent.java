/*
 * This code is the property of Sulfer Development.
 * Copyright (c) 2026, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 */
package com.sulfer.api.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/** Fired when fair teams are announced from the kit then auto/manual picker. */
public class SulferTeamsAnnouncedEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final UUID leader;
    private final String kit;
    private final List<String> teamA;
    private final List<String> teamB;

    public SulferTeamsAnnouncedEvent(UUID leader, String kit,
                                    List<String> teamA, List<String> teamB) {
        this.leader = leader;
        this.kit = kit == null ? "" : kit;
        this.teamA = Collections.unmodifiableList(new ArrayList<String>(teamA));
        this.teamB = Collections.unmodifiableList(new ArrayList<String>(teamB));
    }

    public UUID getLeader() {
        return leader;
    }

    public String getKit() {
        return kit;
    }

    public List<String> getTeamA() {
        return teamA;
    }

    public List<String> getTeamB() {
        return teamB;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
