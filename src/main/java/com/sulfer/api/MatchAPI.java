/*
 * This code is the property of Sulfer Development.
 * Copyright (c) 2026, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 */
package com.sulfer.api;

import java.util.List;
import java.util.UUID;

/**
 * Observational match feed. The core owns real matches, so this API
 * reports what the setup sees (starts/ends off match lines) instead of
 * controlling matches.
 */
public interface MatchAPI {

    /** True while the setup believes this player is inside a match. */
    boolean isInMatch(UUID uuid);

    /** Newest first, capped at the requested size. Never null. */
    List<MatchRecord> getRecentMatches(int max);
}
