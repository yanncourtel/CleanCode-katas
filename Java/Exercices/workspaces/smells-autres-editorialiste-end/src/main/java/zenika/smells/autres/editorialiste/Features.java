package zenika.smells.autres.editorialiste;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableSet;

public class Features {
    
    private final Set<String> features;
    
    public Features(String... features) {
        this.features = asSet(features);
    }

    public static FeatureDiff compare(Features first, Features second) {
        Set<String> sharedByBoth = new HashSet<>(first.features);
        sharedByBoth.retainAll(second.features);
        
        Set<String> specificToFirst = new HashSet<>(first.features);
        specificToFirst.removeAll(sharedByBoth);
        
        Set<String> specificToSecond = new HashSet<>(second.features);
        specificToSecond.removeAll(sharedByBoth);
        
        return new FeatureDiff(specificToFirst, specificToSecond, sharedByBoth);
    }

    @SafeVarargs @SuppressWarnings("varargs")
    private static <T> Set<T> asSet(T... elements) {
        return unmodifiableSet(new HashSet<>(asList(elements)));
    }
}
