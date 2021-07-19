package com.zenika.formation.tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CarAndPassengers03Test {

    @Test
    public void car_should_initially_have_4_free_seats() {
        assertEquals(4, new Car03().freeSeats());
    }

    @Test
    public void car_should_have_3_free_seats_after_taking_1_passenger() {
        Car03 car = new Car03();
        Passenger03 passenger = new Passenger03();
        car.take(passenger);
        assertEquals(3, car.freeSeats());
    }

    @Test
    public void car_should_not_take_more_passengers_than_it_has_seats() {
        Car03 car = new Car03();
        for(int i = 0; i < Car03.SEATS; i++) car.take(new Passenger03());
        try {
            car.take(new Passenger03());
            fail("Should not take more passengers than it has seats");
        } catch(CarFullException success) {
            //expected
        }
    }

}
