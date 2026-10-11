/*
 * This code is the property of Sulfer Development.
 * Copyright (c) 2026, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 */
package com.sulfer.api;

/** Immutable snapshot of one division tier (e.g. Gold). */
public interface DivisionTier {

    /** Tier name, e.g. "Gold". */
    String getName();

    /** Legacy color code string, e.g. "&e". */
    String getColor();

    /** Wins needed to reach this tier. */
    int getMinWins();
}
