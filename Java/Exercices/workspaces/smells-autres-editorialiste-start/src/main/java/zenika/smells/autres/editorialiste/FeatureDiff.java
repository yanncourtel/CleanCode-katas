package zenika.smells.autres.editorialiste;

import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;
import static java.util.Objects.*;

public class FeatureDiff {

    private final Set<String> specificToFirst, specificToSecond, sharedByBoth;

    public FeatureDiff(Set<String> specificToFirst, Set<String> specificToSecond, Set<String> sharedByBoth) {
        this.specificToFirst = new HashSet<>(requireNonNull(specificToFirst));
        this.specificToSecond = new HashSet<>(requireNonNull(specificToSecond));
        this.sharedByBoth = new HashSet<>(requireNonNull(sharedByBoth));
    }

    public Set<String> specificToFirst() {
        return unmodifiableSet(specificToFirst);
    }

    public Set<String> specificToSecond() {
        return unmodifiableSet(specificToSecond);
    }

    public Set<String> sharedByBoth() {
        return unmodifiableSet(sharedByBoth);
    }

}
