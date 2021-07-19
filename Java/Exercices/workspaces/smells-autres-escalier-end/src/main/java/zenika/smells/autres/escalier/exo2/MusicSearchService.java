package zenika.smells.autres.escalier.exo2;

import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static zenika.smells.autres.escalier.exo2.Instrument.Kind.CORDS;

public class MusicSearchService {
    
    public Set<Instrument> cordInstrumentsUsedInLongTracks(Set<Album> albums) {
        return albums.stream()
                .flatMap(album -> album.tracks().stream())
                .filter(Track::isLong)
                .flatMap(track -> track.instruments().stream())
                .filter(instrument -> instrument.kind() == CORDS)
                .collect(toSet());
    }

    public int totalRunningTime(Set<Album> albums) {
        return albums.stream()
                .flatMap(album -> album.tracks().stream())
                .mapToInt(Track::length)
                .sum();
    }
}
