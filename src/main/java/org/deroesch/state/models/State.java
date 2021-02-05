package org.deroesch.state.models;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import lombok.NonNull;

public enum State {
    PA("Pennsylvania", "PA"), CA("California", "CA"), OK("Okalhoma", "OK");

    State(@NonNull String longName, @NonNull String abbrev) {
        this.longName = longName;
        this.shortName = abbrev;
    }

    @Override
    public String toString() {
        return getLongName();
    }

    /*
     * State database
     */
    private static final Map<String, State> stateMap = new HashMap<>();

    /**
     * @return the states as a map
     */
    private static Map<String, State> getAll() {
        return Collections.unmodifiableMap(stateMap);
    }

    /**
     * Find one state given it's longName
     * 
     * @param longName
     * @return
     */
    public static Optional<State> getOne(@NonNull String longName) {
        return Optional.ofNullable(getAll().get(longName));
    }

    static {
        stateMap.put(PA.getLongName(), PA);
        stateMap.put(OK.getLongName(), OK);
        stateMap.put(CA.getLongName(), CA);
    }

    /*
     * Fields and accessors
     */
    @NonNull
    public String getLongName() {
        return longName;
    }

    @NonNull
    public String shortName() {
        return shortName;
    }

    @NonNull
    private String longName;

    @NonNull
    private String shortName;

}
