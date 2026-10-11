/*
 * This code is the property of Sulfer Development.
 * Copyright (c) 2026, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 */
package com.sulfer.api.event;

import com.sulfer.api.DivisionTier;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

/**
 * Fired when a win moves a player into a new tier.
 * kit is null for the general ladder, otherwise the canonical kit id.
 */
public class SulferTierUpEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final UUID uuid;
    private final String kit;
    private final DivisionTier oldTier;
    private final DivisionTier newTier;
    private final int wins;

    public SulferTierUpEvent(UUID uuid, String kit, DivisionTier oldTier,
                             DivisionTier newTier, int wins) {
        this.uuid = uuid;
        this.kit = kit;
        this.oldTier = oldTier;
        this.newTier = newTier;
        this.wins = wins;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getKit() {
        return kit;
    }

    public DivisionTier getOldTier() {
        return oldTier;
    }

    public DivisionTier getNewTier() {
        return newTier;
    }

    public int getWins() {
        return wins;
    }

    public boolean isGeneral() {
        return kit == null;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
