package zenika.supple.guards;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookingTest {

    private final Rooms rooms = mock(Rooms.class);;
    private final BookingService booking = new BookingService(rooms);

    @Before public void setup() {
        Set<Room> oneBigRoom = new HashSet<Room>() {{
            add(new Room(20));
        }};

        when(rooms.findAllRooms()).thenReturn(oneBigRoom);
    }

    @Test public void should_book_when_big_enough_room_is_available() {
        Optional<Room> optionalRoom = booking.book(10);
        assertTrue(optionalRoom.isPresent());
    }
}
