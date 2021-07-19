package zenika.smells.autres.isnota;

import java.util.List;

public class City extends CodeLabel {

    /** The city's airports */
    private List<CodeLabel> airports;

    /** The city's rail stations */
    private List<CodeLabel> railStations;
    
    public List<CodeLabel> getAirports() {
        return this.airports;
    }

    public void setAirports(final List<CodeLabel> airports) {
        this.airports = airports;
    }

    public List<CodeLabel> getRailStations() {
        return this.railStations;
    }

    public void setRailStations(final List<CodeLabel> railStations) {
        this.railStations = railStations;
    }

}
