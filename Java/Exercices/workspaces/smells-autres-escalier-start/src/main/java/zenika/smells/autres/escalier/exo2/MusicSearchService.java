package zenika.smells.autres.escalier.exo2;

import java.util.HashSet;
import java.util.Set;

import static zenika.smells.autres.escalier.exo2.Instrument.Kind.CORDS;

public class MusicSearchService {

    public Set<Instrument> cordInstrumentsUsedInLongTracks(Set<Album> albums) {
        Set<Instrument> res = new HashSet<>();
        for(Album album : albums) {
            //
            //
            for(Track track : album.tracks()) {
                //
                if(track.isLong()) {
                    //
                    //
                    //
                    for(Instrument instrument : track.instruments()) {
                        //
                        if(instrument.kind() == CORDS) {
                            //
                           res.add(instrument);
                        }
                    }
                }
            }
        }
        return res;
    }

    public int totalRunningTime(Set<Album> albums) {
        int res = 0;
        for(Album album : albums) {
            for(Track track : album.tracks()) {
                res += track.length();
            }
        }
        return res;
    }
}
