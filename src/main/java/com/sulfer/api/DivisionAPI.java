/*
 * This code is the property of Sulfer Development.
 * Copyright (c) 2026, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 */
package com.sulfer.api;

import java.util.UUID;

/** Wins-based divisions: one general ladder plus one ladder per kit. */
public interface DivisionAPI {

    /** Total wins feeding the general ladder. */
    int getGeneralWins(UUID uuid);

    /** Wins in one kit (canonical id, e.g. "nodebuff"). */
    int getKitWins(UUID uuid, String kit);

    /** General tier snapshot for a player. */
    DivisionTier getGeneralTier(UUID uuid);

    /** Per-kit tier snapshot for a player. */
    DivisionTier getKitTier(UUID uuid, String kit);
}
