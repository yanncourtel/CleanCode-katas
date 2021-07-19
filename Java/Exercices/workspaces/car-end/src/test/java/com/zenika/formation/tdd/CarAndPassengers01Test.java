package com.zenika.formation.tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CarAndPassengers01Test {

    @Test
    public void car_should_initially_have_4_free_seats() {
        assertEquals(4, new Car01().freeSeats());
    }

}
