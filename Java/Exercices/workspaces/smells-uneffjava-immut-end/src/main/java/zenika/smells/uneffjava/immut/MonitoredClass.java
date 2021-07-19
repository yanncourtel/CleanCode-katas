package zenika.smells.uneffjava.immut;

import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

public class MonitoredClass {
    private final String name;
    private final Set<String> monitoredMethods;

    public MonitoredClass(String name, Set<String> monitoredMethods) {
        this.name = name;
        //Utiliser unmodifiableSet ne marche pas!
        // en effet ce dernier wrappe par une implem qui throw UnsupportedOperationException 
        // quand on appelle add dessus, 
        // mais qui est une "vue" du Set wrappé 
        // -->Si le Set wrappé est modifié directement, notre Set est muté
        // -->Il faut utiliser une copie défensive
        this.monitoredMethods = new HashSet<>(monitoredMethods);
    }

    public Set<String> methodsToInstrument() {
        //Ici il est plus logique de retourner un wrapper qui throw UnsupportedOperationException
        // pour signaler l'intention d'immutabilité au client.
        return unmodifiableSet(this.monitoredMethods);
    }
}
