package zenika.supple.guards;

import java.util.Optional;
import java.util.Set;

public class BookingService {
    
    private final Rooms rooms;

    public BookingService(Rooms rooms) {
        this.rooms = rooms;
    }

    public Optional<Room> book(int minCapacity) {
        Set<Room> allRooms = rooms.findAllRooms();
        return allRooms.stream()
                .filter(r -> r.capacity() >= minCapacity)
                .findAny();
    }
    
}
