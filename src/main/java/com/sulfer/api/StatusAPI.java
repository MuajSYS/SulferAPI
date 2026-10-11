/*
 * This code is the property of Sulfer Development.
 * Copyright (c) 2026, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 */
package com.sulfer.api;

import java.util.UUID;

/** Presence with ingame auto-idle already resolved. */
public interface StatusAPI {

    /** Effective state (invisible included). Never null. */
    StatusState getState(UUID uuid);

    /** Human activity, e.g. "in a fight" or "chilling in lobby". Never null. */
    String getActivity(UUID uuid);

    /** Custom line, possibly empty. Never null. */
    String getMessage(UUID uuid);

    /** True when the player should look offline to everyone. */
    boolean isInvisible(UUID uuid);
}
