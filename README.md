# Sulfer API
Sulfer's public API for divisions, matches, friends, status, stats, hot kits, and fair-team splits.

## Installation
### Maven
```xml
<dependencies>
    <dependency>
        <groupId>com.sulfer</groupId>
        <artifactId>sulfer-api</artifactId>
        <version>1.0.0</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

Grab `sulfer-api-1.0.0.jar` from the
[Releases](https://github.com/SulferDev/SulferAPI/releases) page (or build
it with `mvn package`) and reference it as a `provided` dependency. Never
shade it — at runtime the classes come from the core `SulferDev.jar`
itself, so every plugin sees exactly one copy. Java 8, Bukkit only, no NMS.

## plugin.yml
Your plugin should soft-depend on the core so its classes are visible.

```yml
softdepend:
  - SulferDev
```

## Getting Started
```java
import com.sulfer.api.SulferAPI;

if (!SulferAPI.INSTANCE.isAvailable()) return; // addon not ready yet

SulferAPI api = SulferAPI.INSTANCE;
```

## Division API
```java
import com.sulfer.api.DivisionAPI;
import com.sulfer.api.DivisionTier;

DivisionAPI divisions = api.getDivisionAPI();

int total = divisions.getGeneralWins(player.getUniqueId());
int noDebuff = divisions.getKitWins(player.getUniqueId(), "nodebuff");

DivisionTier general = divisions.getGeneralTier(player.getUniqueId());
DivisionTier kit = divisions.getKitTier(player.getUniqueId(), "sg");
String rank = general.getColor() + general.getName(); // e.g. Gold
int need = general.getMinWins();
```

## Match API
```java
import com.sulfer.api.MatchAPI;
import com.sulfer.api.MatchRecord;

MatchAPI matches = api.getMatchAPI();

boolean fighting = matches.isInMatch(player.getUniqueId());

List<MatchRecord> recent = matches.getRecentMatches(10); // newest first
```

Useful `MatchRecord` runtime methods:

```java
String kind = match.getKind();       // UNRANKED_START, DUEL_START, RANKED_START, ...
String kit = match.getKit();
String winner = match.getWinner();
String loser = match.getLoser();
List<String> duelists = match.getDuelists();
boolean start = match.isStart();
```

The core owns real matches, so this API is observational by design: it
reports starts/ends instead of creating them.

## Friend API
```java
import com.sulfer.api.FriendAPI;

FriendAPI friends = api.getFriendAPI();
UUID me = player.getUniqueId();

boolean areFriends = friends.isFriend(me, other);
boolean starred = friends.isFavorite(me, other);

List<UUID> all = friends.getFriends(me);
List<UUID> online = friends.getOnlineFriends(me); // favorites first
List<UUID> inbox = friends.getIncomingRequests(me);
List<UUID> sent = friends.getOutgoingRequests(me);

String name = friends.getStoredName(someUuid); // offline-friendly
```

## Status API
```java
import com.sulfer.api.StatusAPI;
import com.sulfer.api.StatusState;

StatusAPI status = api.getStatusAPI();
UUID id = player.getUniqueId();

StatusState state = status.getState(id); // ONLINE, IDLE, DND, INVISIBLE
String doing = status.getActivity(id);   // "in a fight", "chilling in lobby", ...
String line = status.getMessage(id);     // custom line, maybe empty
boolean hidden = status.isInvisible(id); // should look offline to everyone
```

States are effective: ingame auto-idle is already applied, invisibles
already resolve to `INVISIBLE`.

## Stats API
```java
import com.sulfer.api.StatsAPI;

StatsAPI stats = api.getStatsAPI();
UUID id = player.getUniqueId();

int wins = stats.getGeneralWins(id);
int kitWins = stats.getKitWins(id, "nodebuff");
int played = stats.getMatches(id);
int series = stats.getBoWins(id);
```

## Hot Kit API
```java
import com.sulfer.api.HotKitAPI;

HotKitAPI hot = api.getHotKitAPI();

List<String> trending = hot.getTopKits("unranked", 3); // display names
int plays = hot.getPlays("ranked", "sg");
```

Buckets are `"unranked"` and `"ranked"`, over the rolling 7-day window.

## Split API
```java
import com.sulfer.api.SplitAPI;

SplitAPI split = api.getSplitAPI();

List<String> presets = split.getPresetNames(); // saved fair-team setups
```

## Events
Match feed (feed these straight into analysis):

```java
@EventHandler
public void onStart(SulferMatchStartEvent event) {
    MatchRecord match = event.getMatch();
}

@EventHandler
public void onEnd(SulferMatchEndEvent event) {
    MatchRecord match = event.getMatch();
}
```

Tier-ups (kit is null on the general ladder):

```java
@EventHandler
public void onTier(SulferTierUpEvent event) {
    DivisionTier now = event.getNewTier();
    if (event.isGeneral()) {
        // event.getUuid(), event.getWins()
    }
}
```

Friends and presence:

```java
@EventHandler
public void onRequest(SulferFriendRequestEvent event) {
    UUID from = event.getFrom();
    UUID to = event.getTo();
}

@EventHandler
public void onAccept(SulferFriendAcceptEvent event) {
    UUID owner = event.getOwner();
    UUID friend = event.getFriend();
}

@EventHandler
public void onStatus(SulferStatusChangeEvent event) {
    StatusState now = event.getNewState();
}
```

Fair teams:

```java
@EventHandler
public void onTeams(SulferTeamsAnnouncedEvent event) {
    String kit = event.getKit();
    List<String> teamA = event.getTeamA();
    List<String> teamB = event.getTeamB();
}
```

## Rules
- Reads before anything: `SulferAPI.INSTANCE.isAvailable()` until SulferAddon enables.
- All getters are null-safe; events fire on the main thread.
- Never shade `sulfer-api` — the core jar is the one runtime copy.
