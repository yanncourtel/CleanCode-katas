package zenika.smells.mf.dupmethod;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableSet;
import static zenika.smells.mf.dupmethod.Instrument.Kind;


public class MusicLibrary {

    public static final Instrument
            guitar = Instrument.of(Kind.CORDS),
            violin = Instrument.of(Kind.CORDS),
            trumpet = Instrument.of(Kind.COPPER),
            drums = Instrument.of(Kind.PERCUSSION);
    public static final Artist
            vanHalen = Artist.named("Van Halen"),
            richter = Artist.named("Richter"),
            masayuki = Artist.named("Masayuki"),
            takayanagi = Artist.named("Takayanagi");

    public static Set<Instrument> allInstruments() {
        return asSet(
                guitar, violin, trumpet, drums
        );
    }

    public static Set<Artist> allArtists() {
        return asSet(
                vanHalen, richter, masayuki, takayanagi
        );
    }

    @SafeVarargs
    @SuppressWarnings("varargs")
    private static <T> Set<T> asSet(T... elts) {
        return unmodifiableSet(new HashSet<>(asList(elts)));
    }
}
