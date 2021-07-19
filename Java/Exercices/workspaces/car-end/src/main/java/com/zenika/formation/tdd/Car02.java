package com.zenika.formation.tdd;

import java.util.HashSet;
import java.util.Set;

public class Car02 {
    public static final int SEATS = 4;

    private final Set<Passenger02> passengers = new HashSet<>();

    public int freeSeats() {
        return SEATS - passengers.size();
    }

    public void take(Passenger02 p) {
        passengers.add(p);
    }
}
