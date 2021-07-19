package zenika.smells.autres.escalier.exo2;

import java.util.Set;

import static zenika.smells.autres.escalier.exo2.U.asSet;

public class Track {
    private final String title;
    private final int minutes;
    private final Set<Artist> artists;
    private final Set<Instrument> instruments;

    private Track(String title, int minutes, Set<Artist> artists, Set<Instrument> instruments) {
        this.title = title;
        this.minutes = minutes;
        this.artists = artists;
        this.instruments = instruments;
    }

    public static Builder titled(String title) {
        return new Builder(title);
    }

    public boolean isLong() {
        return minutes >= 10;
    }

    public Set<Instrument> instruments() {
        return this.instruments;
    }

    public int length() {
        return minutes;
    }

    public static class Builder {
        private final String title;
        private int minutes;
        private Set<Artist> artists;
        private Set<Instrument> instruments;

        public Builder(String title) {
            this.title = title;
        }

        public Builder ofLength(int minutes) {
            this.minutes = minutes;
            return this;
        }

        public Builder where(Artist... artists) {
            this.artists = asSet(artists);
            return this;
        }

        public Track plays(Instrument... instruments) {
            this.instruments = asSet(instruments);
            return new Track(this.title, this.minutes, this.artists, this.instruments);
        }
    }
}
