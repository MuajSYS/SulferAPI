/*
 * This code is the property of Sulfer Development.
 * Copyright (c) 2026, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 */
package com.sulfer.api;

import java.util.UUID;

/** Counters the setup keeps per player. */
public interface StatsAPI {

    int getGeneralWins(UUID uuid);

    int getKitWins(UUID uuid, String kit);

    int getMatches(UUID uuid);

    int getBoWins(UUID uuid);
}
