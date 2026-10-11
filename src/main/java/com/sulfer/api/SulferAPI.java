/*
 * This code is the property of Sulfer Development.
 * Copyright (c) 2026, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 */
package com.sulfer.api;

/**
 * Entry point other plugins use to talk to the Sulfer practice setup.
 * Mirror of the BoltAPI idea: one enum singleton holding every domain API.
 *
 * <pre>
 *   softdepend: [SulferAddon]
 *
 *   SulferAPI api = SulferAPI.INSTANCE;
 *   int wins = api.getStatsAPI().getGeneralWins(player.getUniqueId());
 * </pre>
 *
 * Every getter throws IllegalStateException until SulferAddon enables and
 * registers its implementations. Use {@link #isAvailable()} first.
 */
public enum SulferAPI {

    INSTANCE;

    private DivisionAPI divisionAPI;
    private MatchAPI matchAPI;
    private FriendAPI friendAPI;
    private StatusAPI statusAPI;
    private StatsAPI statsAPI;
    private HotKitAPI hotKitAPI;
    private SplitAPI splitAPI;

    /** True once SulferAddon has enabled and registered everything. */
    public boolean isAvailable() {
        return divisionAPI != null && matchAPI != null && friendAPI != null
                && statusAPI != null && statsAPI != null
                && hotKitAPI != null && splitAPI != null;
    }

    private static void check(Object api, String name) {
        if (api == null) {
            throw new IllegalStateException(name + " has not been initialized yet (is SulferAddon enabled?).");
        }
    }

    public DivisionAPI getDivisionAPI() {
        check(divisionAPI, "DivisionAPI");
        return divisionAPI;
    }

    public void setDivisionAPI(DivisionAPI divisionAPI) {
        this.divisionAPI = divisionAPI;
    }

    public MatchAPI getMatchAPI() {
        check(matchAPI, "MatchAPI");
        return matchAPI;
    }

    public void setMatchAPI(MatchAPI matchAPI) {
        this.matchAPI = matchAPI;
    }

    public FriendAPI getFriendAPI() {
        check(friendAPI, "FriendAPI");
        return friendAPI;
    }

    public void setFriendAPI(FriendAPI friendAPI) {
        this.friendAPI = friendAPI;
    }

    public StatusAPI getStatusAPI() {
        check(statusAPI, "StatusAPI");
        return statusAPI;
    }

    public void setStatusAPI(StatusAPI statusAPI) {
        this.statusAPI = statusAPI;
    }

    public StatsAPI getStatsAPI() {
        check(statsAPI, "StatsAPI");
        return statsAPI;
    }

    public void setStatsAPI(StatsAPI statsAPI) {
        this.statsAPI = statsAPI;
    }

    public HotKitAPI getHotKitAPI() {
        check(hotKitAPI, "HotKitAPI");
        return hotKitAPI;
    }

    public void setHotKitAPI(HotKitAPI hotKitAPI) {
        this.hotKitAPI = hotKitAPI;
    }

    public SplitAPI getSplitAPI() {
        check(splitAPI, "SplitAPI");
        return splitAPI;
    }

    public void setSplitAPI(SplitAPI splitAPI) {
        this.splitAPI = splitAPI;
    }
}
