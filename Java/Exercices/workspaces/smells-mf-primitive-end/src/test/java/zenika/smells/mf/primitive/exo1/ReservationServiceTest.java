package zenika.smells.mf.primitive.exo1;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

import static java.util.Collections.emptySet;
import static java.util.Collections.singleton;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static zenika.smells.mf.primitive.exo1.CreneauHoraire.aujourdhui;

public class ReservationServiceTest {

    private static final Set<Salle> LA_SALLE = singleton(new Salle());
    private static final Reservation
            DE_10_A_12 = new Reservation(aujourdhui().de(10).a(12)),
            DE_13_A_14 = new Reservation(aujourdhui().de(13).a(14)),
            DE_13_A_15 = new Reservation(aujourdhui().de(13).a(15)),
            DE_14_A_17 = new Reservation(aujourdhui().de(14).a(17)),
            DE_15_A_16 = new Reservation(aujourdhui().de(15).a(16)),
            DE_16_A_18 = new Reservation(aujourdhui().de(16).a(18)),
            DE_17_A_18 = new Reservation(aujourdhui().de(17).a(18));

    private Reservations reservations;
    private ReservationService reservationService;

    @Test
    public void devrait_proposer_une_salle_quand_pas_de_reservations_preexistantes() {
        quandIlNyaPasDeReservationsPreexistantes();
            //Signature de findSalleReservable encore un peu compliquee: 
            // on pourrait introduire une SpecificationDeReservation
            assertTrue(reservationService.findSalleReservable(8, aujourdhui().de(14).a(17)).isPresent());
    }

    @Test
    public void devrait_proposer_une_salle_quand_pas_de_reservations_preexistantes_qui_chevauche_1() {
        quandLaSeuleReservationPreexistanteEst(DE_10_A_12);
            assertTrue(reservationService.findSalleReservable(8, aujourdhui().de(14).a(17)).isPresent());
    }

    @Test
    public void devrait_proposer_une_salle_quand_pas_de_reservations_preexistantes_qui_chevauche_2() {
        quandLaSeuleReservationPreexistanteEst(DE_13_A_14);
            assertTrue(reservationService.findSalleReservable(8, aujourdhui().de(14).a(17)).isPresent());
    }

    @Test
    public void devrait_proposer_une_salle_quand_pas_de_reservations_preexistantes_qui_chevauche_3() {
        quandLaSeuleReservationPreexistanteEst(DE_17_A_18);
            assertTrue(reservationService.findSalleReservable(8, aujourdhui().de(14).a(17)).isPresent());
    }

    @Test
    public void ne_devrait_pas_proposer_une_salle_quand_une_reservations_preexistante_chevauche_1() {
        quandLaSeuleReservationPreexistanteEst(DE_14_A_17);
            assertFalse(reservationService.findSalleReservable(8, aujourdhui().de(14).a(17)).isPresent());
    }

    @Test
    public void ne_devrait_pas_proposer_une_salle_quand_une_reservations_preexistante_chevauche_2() {
        quandLaSeuleReservationPreexistanteEst(DE_15_A_16);
            assertFalse(reservationService.findSalleReservable(8, aujourdhui().de(14).a(17)).isPresent());
    }

    @Test
    public void ne_devrait_pas_proposer_une_salle_quand_une_reservations_preexistante_chevauche_3() {
        quandLaSeuleReservationPreexistanteEst(DE_13_A_15);
        assertFalse(reservationService.findSalleReservable(8, aujourdhui().de(14).a(17)).isPresent());
    }

    @Test
    public void ne_devrait_pas_proposer_une_salle_quand_une_reservations_preexistante_chevauche_4() {
        quandLaSeuleReservationPreexistanteEst(DE_16_A_18);
            assertFalse(reservationService.findSalleReservable(8, aujourdhui().de(14).a(17)).isPresent());
    }


    @Before
    public void setup() {
        Salles salles = mock(Salles.class);
        when(salles.findSallesByCapacite(anyInt())).thenReturn(LA_SALLE);

        reservations = mock(Reservations.class);

        reservationService = new ReservationService(salles, reservations);
    }


    private void quandIlNyaPasDeReservationsPreexistantes() {
        quandLaSeuleReservationsPreexistanteSont(emptySet());
    }
    private void quandLaSeuleReservationPreexistanteEst(Reservation preexistingReservation) {
        quandLaSeuleReservationsPreexistanteSont(singleton(preexistingReservation));
    }
    private void quandLaSeuleReservationsPreexistanteSont(Set<Reservation> preexistingReservations) {
        when(
                reservations.findReservations(any(), any())
        ).thenReturn(preexistingReservations);
    }
}
