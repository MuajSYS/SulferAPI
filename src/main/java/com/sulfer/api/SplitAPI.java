/*
 * This code is the property of Sulfer Development.
 * Copyright (c) 2026, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 */
package com.sulfer.api;

import java.util.List;

/** Saved fair-team presets from the kit then auto/manual picker. */
public interface SplitAPI {

    /** Preset names, sorted. Never null. */
    List<String> getPresetNames();
}
