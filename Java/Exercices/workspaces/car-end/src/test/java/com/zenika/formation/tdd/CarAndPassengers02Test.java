package com.zenika.formation.tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CarAndPassengers02Test {

    @Test
    public void car_should_initially_have_4_free_seats() {
        assertEquals(4, new Car02().freeSeats());
    }

    @Test
    public void car_should_have_3_free_seats_after_taking_1_passenger() {
        Car02 car = new Car02();
        Passenger02 passenger = new Passenger02();
        car.take(passenger);
        assertEquals(3, car.freeSeats());
    }

}
