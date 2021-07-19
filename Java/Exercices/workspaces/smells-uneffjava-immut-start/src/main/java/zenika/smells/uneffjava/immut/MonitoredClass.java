package zenika.smells.uneffjava.immut;

import java.util.Set;

public class MonitoredClass {
    private final String name;
    private final Set<String> monitoredMethods;

    public MonitoredClass(String name, Set<String> monitoredMethods) {
        this.name = name;
        this.monitoredMethods = monitoredMethods;
    }

    public Set<String> methodsToInstrument() {
        return monitoredMethods;
    }
}
