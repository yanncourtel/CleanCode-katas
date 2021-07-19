package zenika.smells.autres.escalier.exo2;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableSet;

public class U {
    
    @SafeVarargs @SuppressWarnings("varargs")
    static <T> Set<T> asSet(T... elts) {
        return unmodifiableSet(new HashSet<>(asList(elts)));
    }
}
