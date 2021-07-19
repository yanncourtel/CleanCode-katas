package com.zenika.formation.tdd;

import java.util.HashSet;
import java.util.Set;

public class Car03 {
    public static final int SEATS = 4;

    private final Set<Passenger03> passengers = new HashSet<>();

    public int freeSeats() {
        return SEATS - passengers.size();
    }

    public void take(Passenger03 p) {
        if(freeSeats() == 0) throw new CarFullException();
        passengers.add(p);
    }
}
