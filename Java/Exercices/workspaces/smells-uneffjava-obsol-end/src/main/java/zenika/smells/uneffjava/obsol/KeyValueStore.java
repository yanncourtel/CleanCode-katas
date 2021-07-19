package zenika.smells.uneffjava.obsol;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static java.nio.file.Files.lines;
import static java.nio.file.Paths.get;

public class KeyValueStore {

    private static final int STORE_MAX_SIZE = 1_000_000_000;
    private final Map<String, String> keyValueStore = new HashMap<>();

    public void importFile(String path) throws IOException {
        lines(get(path))
            .forEach(KeyValueStore::importLine);
    }

    private static void importLine(String line) {

    }

}
