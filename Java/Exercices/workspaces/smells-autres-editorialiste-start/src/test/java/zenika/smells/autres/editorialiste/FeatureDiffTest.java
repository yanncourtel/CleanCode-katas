package zenika.smells.autres.editorialiste;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class FeatureDiffTest {

    private final Features
        ghostery = new Features(
            "blocks tracking cookies",
            "works well"
        ),
        privacyBadger = new Features(
            "blocks tracking cookies",
            "is trustworthy"
        );

    @Test public void should_find_ghostery_specific_features() {
        assertThat(
                Features.compare(ghostery, privacyBadger).specificToFirst()
        ).containsExactly("works well");
    }

    @Test public void should_find_privacy_badger_specific_features() {
        assertThat(
                Features.compare(ghostery, privacyBadger).specificToSecond()
        ).containsExactly("is trustworthy");
    }

    @Test public void should_find_features_shared_by_both() {
        assertThat(
                Features.compare(ghostery, privacyBadger).sharedByBoth()
        ).containsExactly("blocks tracking cookies");
    }
}
