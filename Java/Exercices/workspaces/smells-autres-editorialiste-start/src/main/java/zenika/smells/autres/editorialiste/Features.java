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
    
    public static FeatureDiff compare(Features f1, Features f2) {
        Set<String> s1, s2, s3; 
        
        //Features shared by both f1 and f2
        s3 = new HashSet<>(f1.features);
        s3.retainAll(f2.features);
        
        //Features that are included in f1 but not f2
        s1 = new HashSet<>(f1.features);
        s1.removeAll(s3);
        
        //Features that are included in f2 but not f1
        s2 = new HashSet<>(f2.features);
        s2.removeAll(s3);
        
        return new FeatureDiff(s1, s2, s3);
    } 

    
    
    @SafeVarargs @SuppressWarnings("varargs")
    private static <T> Set<T> asSet(T... elements) {
        return unmodifiableSet(new HashSet<>(asList(elements)));
    }
}
