package zenika.smells.autres.escalier.exo2;

import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static zenika.smells.autres.escalier.exo2.MusicLibrary.*;


public class MusicSearchServiceTest {

    private final MusicSearchService musicSearchService = new MusicSearchService();

    @Test public void should_count_total_running_time() {
        int totalRunningTime = musicSearchService.totalRunningTime(albums);
        assertThat(totalRunningTime).isEqualTo(119);    
    }
    
    @Test public void should_find_cord_instruments_used_in_long_tracks() {
        Set<Instrument> instrumentsUsedInLongTracks = musicSearchService.cordInstrumentsUsedInLongTracks(albums);
        assertThat(instrumentsUsedInLongTracks).hasSize(2).contains(guitar, violin);
    }
    
}
