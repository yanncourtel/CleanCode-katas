package com.zenika.formation.tdd;

import java.util.Objects;
import java.util.UUID;

public class Passenger04 {

    private final String name;

    public Passenger04(String name) {
        this.name = name;
    }

    public Passenger04() {
        this(UUID.randomUUID().toString());
    }

    @Override public boolean equals(Object obj) {
        if(! (obj instanceof Passenger04)) return false;
        Passenger04 that = (Passenger04) obj;
        return Objects.equals(this.name, that.name);
    }

    @Override public int hashCode() {
        return Objects.hash(name);
    }
}
