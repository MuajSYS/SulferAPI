/*
 * This code is the property of Sulfer Development.
 * Copyright (c) 2026, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 */
package com.sulfer.api;

import java.util.List;

/**
 * Kit demand over the rolling window.
 * bucket is "unranked" or "ranked".
 */
public interface HotKitAPI {

    /** Display names, most played first. Never null. */
    List<String> getTopKits(String bucket, int max);

    /** Plays in the window for one kit id. */
    int getPlays(String bucket, String kit);
}
