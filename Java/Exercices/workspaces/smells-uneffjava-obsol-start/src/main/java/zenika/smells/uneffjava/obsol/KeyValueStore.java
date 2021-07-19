package zenika.smells.uneffjava.obsol;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class KeyValueStore {
    
    private static final int STORE_MAX_SIZE = 1000000000;
    private final Map<String, String> keyValueStore = new HashMap<String, String>();
    
    public void importFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            importFile(br);
        } finally {
            br.close();
        }
    }

    private void importFile(BufferedReader br) throws IOException {
        String line = null;
        while((line=br.readLine()) != null) {
            importLine(line);
        }    
    }

    private void importLine(String line) {
        
    }

}
