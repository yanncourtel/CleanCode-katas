package zenika.smells.autres.modtech;

import jdepend.framework.DependencyConstraint;
import jdepend.framework.JDepend;
import jdepend.framework.JavaPackage;
import org.junit.Test;

import java.io.IOException;
import static org.junit.Assert.*;

public class DependenciesTest {

    private final JDepend jdepend = new JDepend();

    public void setup() throws IOException {
        //jdepend.addDirectory("C:\\projects\\zenika\\formation-clean-code\\formation-clean-code\\Exercices\\workspaces\\smells-autres-modtech-end\\target\\classes");
        jdepend.addDirectory(".");
    }

    @Test
    public void no_cycles() {
        DependencyConstraint constraint = new DependencyConstraint();
        JavaPackage software = constraint.addPackage("zenika.smells.autres.modtech");
        jdepend.analyze();
        assertFalse(software.containsCycle());
    }

    @Test
    public void domain_should_depend_on_nothing() {
        DependencyConstraint constraint = new DependencyConstraint();

        JavaPackage software = constraint.addPackage("zenika.smells.autres.modtech");
        JavaPackage domain = constraint.addPackage("zenika.smells.autres.modtech.domain");
        JavaPackage application = constraint.addPackage("zenika.smells.autres.modtech.application");
        JavaPackage infrastructure = constraint.addPackage("zenika.smells.autres.modtech.infrastructure");

        application.dependsUpon(domain);
        infrastructure.dependsUpon(domain);

        jdepend.analyze();

        assertFalse(software.containsCycle());
//        assertTrue(jdepend.dependencyMatch(constraint));
    }

}
