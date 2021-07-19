package com.zenika.formation.tdd;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Car05 {
    public static final int SEATS = 4;

    private final Set<Passenger05> passengers = new HashSet<>();

    public int freeSeats() {
        return SEATS - passengers.size();
    }

    public void take(Passenger05 p) {
        if(freeSeats() == 0) throw new CarFullException();
        if(passengers.contains(p)) throw new PassengerAlreadyInCarException();
        passengers.add(p);
    }
}
