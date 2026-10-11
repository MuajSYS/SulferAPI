/*
 * This code is the property of Sulfer Development.
 * Copyright (c) 2026, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 */
package com.sulfer.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Immutable snapshot of one observed match line.
 * kind is one of UNRANKED_START, DUEL_START, RANKED_START, PREMIUM_START,
 * PARTY_START, MATCH_END.
 */
public final class MatchRecord {

    private final String kind;
    private final String kit;
    private final String winner;
    private final String loser;
    private final List<String> duelists;
    private final long timeMillis;

    public MatchRecord(String kind, String kit, String winner, String loser,
                       List<String> duelists, long timeMillis) {
        this.kind = kind == null ? "UNKNOWN" : kind;
        this.kit = kit;
        this.winner = winner;
        this.loser = loser;
        this.duelists = duelists == null
                ? Collections.<String>emptyList()
                : Collections.unmodifiableList(new ArrayList<String>(duelists));
        this.timeMillis = timeMillis;
    }

    public String getKind() {
        return kind;
    }

    public String getKit() {
        return kit;
    }

    public String getWinner() {
        return winner;
    }

    public String getLoser() {
        return loser;
    }

    public List<String> getDuelists() {
        return duelists;
    }

    public long getTimeMillis() {
        return timeMillis;
    }

    public boolean isStart() {
        return kind.endsWith("_START");
    }
}
