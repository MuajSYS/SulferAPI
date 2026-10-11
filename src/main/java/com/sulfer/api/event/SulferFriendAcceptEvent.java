/*
 * This code is the property of Sulfer Development.
 * Copyright (c) 2026, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 */
package com.sulfer.api.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

/** Fired when two players become friends (accept or instant mutual). */
public class SulferFriendAcceptEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final UUID owner;
    private final UUID friend;

    public SulferFriendAcceptEvent(UUID owner, UUID friend) {
        this.owner = owner;
        this.friend = friend;
    }

    public UUID getOwner() {
        return owner;
    }

    public UUID getFriend() {
        return friend;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
