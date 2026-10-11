/*
 * This code is the property of Sulfer Development.
 * Copyright (c) 2026, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 */
package com.sulfer.api.event;

import com.sulfer.api.MatchRecord;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/** Fired for every observed match start line (any mode). */
public class SulferMatchStartEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final MatchRecord match;

    public SulferMatchStartEvent(MatchRecord match) {
        this.match = match;
    }

    public MatchRecord getMatch() {
        return match;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
