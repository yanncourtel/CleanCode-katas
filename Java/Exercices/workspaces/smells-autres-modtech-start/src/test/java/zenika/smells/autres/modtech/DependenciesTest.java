package zenika.smells.autres.modtech;

import jdepend.framework.DependencyConstraint;
import jdepend.framework.JDepend;
import jdepend.framework.JavaPackage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.IOException;

public class DependenciesTest {

    private final JDepend jdepend = new JDepend();

    public void setup() throws IOException {
        jdepend.addDirectory("/path/to/project/util/classes");
        jdepend.addDirectory("/path/to/project/ejb/classes");
        jdepend.addDirectory("/path/to/project/web/classes");
    }

     @Test
    public void no_cycles() {
        DependencyConstraint constraint = new DependencyConstraint();
        JavaPackage software = constraint.addPackage("zenika.smells.autres.modtech");
        jdepend.analyze();
        assertFalse(software.containsCycle());
    }

    public void testMatch() {
        DependencyConstraint constraint = new DependencyConstraint();

        JavaPackage domain = constraint.addPackage("zenika.smells.autres.modtech.application.products");
        JavaPackage application = constraint.addPackage("com.xyz.web");
        JavaPackage infrastructure = constraint.addPackage("com.xyz.util");

        domain.dependsUpon(infrastructure);
        application.dependsUpon(infrastructure);

        jdepend.analyze();

        assertEquals("Dependency mismatch",
                true, jdepend.dependencyMatch(constraint));
    }

}
