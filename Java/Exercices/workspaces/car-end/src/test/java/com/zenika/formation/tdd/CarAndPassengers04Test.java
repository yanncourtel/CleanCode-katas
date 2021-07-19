package com.zenika.formation.tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CarAndPassengers04Test {

    @Test
    public void car_should_initially_have_4_free_seats() {
        assertEquals(4, new Car04().freeSeats());
    }

    @Test
    public void car_should_have_3_free_seats_after_taking_1_passenger() {
        Car04 car = new Car04();
        Passenger04 passenger = new Passenger04();
        car.take(passenger);
        assertEquals(3, car.freeSeats());
    }

    @Test
    public void car_should_not_take_more_passengers_than_it_has_seats() {
        Car04 car = new Car04();
        for(int i = 0; i < Car04.SEATS; i++) car.take(new Passenger04());
        try {
            car.take(new Passenger04());
            fail("Should not take more passengers than it has seats");
        } catch(CarFullException success) {
            //expected
        }
    }

    /**
     * 1/ Quelle est la notion de "same passenger" à tester?
     * On va supposer que les passagers sont identifiés par leur nom, supposé unique
     *
     * 2/ Autre point: qd on crée le constructeur avec arg de Passenger,
     * le constructeur par défaut disparait.
     * Plutôt que de casser tous les tests, on crée temporairement un constructeur par défaut.
     * Il sera supprimé dans le test suivant.
     * -->Ceci illustre le principe selon lequel on change une chose à la fois:
     *  1/ le nouveau test
     *  2/ le refactor de passenger
     */
    @Test
    public void car_should_not_take_same_passengers_twice() {
        Car04 car = new Car04();
        car.take(new Passenger04("foo"));
        try {
            car.take(new Passenger04("foo"));
            fail("Should not take the same passenger twice");
        } catch(PassengerAlreadyInCarException success) {
            //expected
        }
    }

}

