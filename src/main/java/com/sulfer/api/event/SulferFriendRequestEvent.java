/*
 * This code is the property of Sulfer Development.
 * Copyright (c) 2026, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 */
package com.sulfer.api.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

/** Fired when a friend request is sent (not on instant mutual match). */
public class SulferFriendRequestEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final UUID from;
    private final UUID to;

    public SulferFriendRequestEvent(UUID from, UUID to) {
        this.from = from;
        this.to = to;
    }

    public UUID getFrom() {
        return from;
    }

    public UUID getTo() {
        return to;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
