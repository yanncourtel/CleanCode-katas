package com.zenika.formation.tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CarAndPassengers05Test {

    @Test
    public void car_should_initially_have_4_free_seats() {
        assertEquals(4, new Car05().freeSeats());
    }

    @Test
    public void car_should_have_3_free_seats_after_taking_1_passenger() {
        Car05 car = new Car05();
        Passenger05 passenger = new Passenger05("foo");
        car.take(passenger);
        assertEquals(3, car.freeSeats());
    }

    @Test
    public void car_should_not_take_more_passengers_than_it_has_seats() {
        Car05 car = new Car05();
        for(int i = 0; i < Car04.SEATS; i++) car.take(new Passenger05("foo"+i));
        try {
            car.take(new Passenger05("foo"));
            fail("Should not take more passengers than it has seats");
        } catch(CarFullException success) {
            //expected
        }
    }

    @Test
    public void car_should_not_take_same_passengers_twice() {
        Car05 car = new Car05();
        car.take(new Passenger05("foo"));
        try {
            car.take(new Passenger05("foo"));
            fail("Should not take the same passenger twice");
        } catch(PassengerAlreadyInCarException success) {
            //expected
        }
    }

}

