package zenika.supple.guards;

import java.util.Optional;
import java.util.Set;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

public class BookingService {

    private final Rooms rooms;

    public BookingService(Rooms rooms) {
        this.rooms = requireNonNull(rooms);
    }

    public Optional<Room> book(int minCapacity) {
        throwIfInvalidCapacity(minCapacity);

        Set<Room> allRooms = rooms.findAllRooms();
        return allRooms.stream()
                .filter(room -> room.capacity() >= minCapacity)
                .findAny();
    }

    private static void throwIfInvalidCapacity(int minCapacity) {
        if(minCapacity < 1) throw new IllegalArgumentException(format(
                "Invalid minCapacity(%d): minCapacity < 1",
                minCapacity
        ));
    }
}
