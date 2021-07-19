package zenika.smells.autres.escalier.exo2;

import java.util.Set;

import static zenika.smells.autres.escalier.exo2.Instrument.Kind.*;
import static zenika.smells.autres.escalier.exo2.U.asSet;

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
    public static final Track
            eruption = Track.titled("Eruption").ofLength(12).where(vanHalen).plays(guitar),
            atomicPunk = Track.titled("Atomic punk").ofLength(7).where(vanHalen).plays(guitar),
            artOfFugue = Track.titled("Art Of fugue").ofLength(30).where(richter).plays(violin),
            concerto1InAMinor = Track.titled("Concerto in A minor").ofLength(60).where(richter).plays(violin),
            massHysterism = Track.titled("Mass hysterism").ofLength(10).where(masayuki, takayanagi).plays(trumpet, drums);
    public static final Album
            fairWarning = Album.titled("Fair Warning").containingTracks(eruption, atomicPunk),
            bachByRichter = Album.titled("Bach where Richter").containingTracks(artOfFugue, concerto1InAMinor),
            freeFreeJazz = Album.titled("Free free jazz").containingTracks(massHysterism);
    public static final Set<Album> albums = asSet(
            fairWarning, bachByRichter, freeFreeJazz
    );

}
