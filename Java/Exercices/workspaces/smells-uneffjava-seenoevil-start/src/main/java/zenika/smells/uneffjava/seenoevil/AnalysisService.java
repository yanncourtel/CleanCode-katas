package zenika.smells.uneffjava.seenoevil;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.ThreadLocalRandom;

public class AnalysisService {

    static final Logger log = LoggerFactory.getLogger(AnalysisService.class);

    public void updateMetricsWith(Path pathOfNewData) {
        try {
            importNewDataIntoIntoStore(pathOfNewData);
        } catch (IOException e) {
            log.error("import failed: ", e);
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
