package zenika.smells.uneffjava.seenoevil;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Path;
import java.util.concurrent.ThreadLocalRandom;

public class AnalysisService {

    static final Logger log = LoggerFactory.getLogger(AnalysisService.class);

    public void updateMetricsWith(Path pathOfNewData) {
        try {
            importNewDataIntoIntoStore(pathOfNewData);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        refreshMetrics();
    }

    private void importNewDataIntoIntoStore(Path pathOfNewData) throws IOException {
        if (ThreadLocalRandom.current().nextBoolean()) {
            throw new IOException();
        }
    }

    private void refreshMetrics() {

    }
}
