package com.zenika.formation.tdd;

import java.util.Objects;
import java.util.UUID;

public class Passenger05 {

    private final String name;

    public Passenger05(String name) {
        this.name = name;
    }

    @Override public boolean equals(Object obj) {
        if(! (obj instanceof Passenger05)) return false;
        Passenger05 that = (Passenger05) obj;
        return Objects.equals(this.name, that.name);
    }

    @Override public int hashCode() {
        return Objects.hash(name);
    }
}
