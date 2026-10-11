/*
 * This code is the property of Sulfer Development.
 * Copyright (c) 2026, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 */
package com.sulfer.api;

import java.util.List;
import java.util.UUID;

/** Read-only view of the friends graph. */
public interface FriendAPI {

    boolean isFriend(UUID owner, UUID other);

    boolean isFavorite(UUID owner, UUID friend);

    /** Never null. */
    List<UUID> getFriends(UUID owner);

    /** Online friends, favorites first. Never null. */
    List<UUID> getOnlineFriends(UUID owner);

    /** Incoming pending requests. Never null. */
    List<UUID> getIncomingRequests(UUID owner);

    /** Outgoing pending requests. Never null. */
    List<UUID> getOutgoingRequests(UUID owner);

    /** Last known name (offline-friendly). Never null. */
    String getStoredName(UUID uuid);
}
