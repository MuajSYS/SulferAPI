/*
 * This code is the property of Sulfer Development.
 * Copyright (c) 2026, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 */
package com.sulfer.api.event;

import com.sulfer.api.StatusState;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

/** Fired when a player's manual status or line changes. */
public class SulferStatusChangeEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final UUID uuid;
    private final StatusState oldState;
    private final StatusState newState;

    public SulferStatusChangeEvent(UUID uuid, StatusState oldState, StatusState newState) {
        this.uuid = uuid;
        this.oldState = oldState;
        this.newState = newState;
    }

    public UUID getUuid() {
        return uuid;
    }

    public StatusState getOldState() {
        return oldState;
    }

    public StatusState getNewState() {
        return newState;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
