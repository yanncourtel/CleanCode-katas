package zenika.smells.mf.dupmethod;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableSet;
import static zenika.smells.mf.dupmethod.Instrument.Kind.*;

public class MusicLibrary {

    public static final Instrument
            guitar = Instrument.of(CORDS),
            violin = Instrument.of(CORDS),
            trumpet = Instrument.of(COPPER),
            drums = Instrument.of(PERCUSSION);
    public static final Artist
            vanHalen = Artist.named("Van Halen"),
            richter = Artist.named("Richter"),
            masayuki = Artist.named("Masayuki"),
            takayanagi = Artist.named("Takayanagi");

    public static Set<Instrument> allInstruments() {
        return unmodifiableSet(new HashSet<>(asList(
                guitar, violin, trumpet, drums
        )));
    }

    public static Set<Artist> allArtists() {
        return unmodifiableSet(new HashSet<>(asList(
            vanHalen, richter, masayuki, takayanagi
        )));
    }

}
