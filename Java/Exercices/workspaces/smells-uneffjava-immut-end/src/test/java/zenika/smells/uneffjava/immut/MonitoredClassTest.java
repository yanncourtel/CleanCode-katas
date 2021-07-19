package zenika.smells.uneffjava.immut;

import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;


public class MonitoredClassTest {
    
    @Test public void monitored_methods_should_be_immutable_1() {
        //Lu depuis un fichier de conf, pour instrumentation du bytecode 
        // en vue de rajouter des logs de perfs. 
        String theClassNameToMonitor = "com.enterprise.booking.ReserverSalle"; 
        Set<String> theMethodNamesToMonitor = new HashSet<String>(){{add("reserver");}};
        
        MonitoredClass theClassToMonitor = new MonitoredClass(theClassNameToMonitor, theMethodNamesToMonitor);
        assertEquals(1, theClassToMonitor.methodsToInstrument().size());
        
        theMethodNamesToMonitor.add("toto");
        assertEquals(1, theClassToMonitor.methodsToInstrument().size());
    }
    
    @Test(expected = UnsupportedOperationException.class) 
    public void monitored_methods_should_be_immutable_2() {
        //Lu depuis un fichier de conf, pour instrumentation du bytecode 
        // en vue de rajouter des logs de perfs. 
        String theClassNameToMonitor = "com.enterprise.booking.ReserverSalle"; 
        Set<String> theMethodNamesToMonitor = new HashSet<String>(){{add("reserver");}};
        
        MonitoredClass theClassToMonitor = new MonitoredClass(theClassNameToMonitor, theMethodNamesToMonitor);
        assertEquals(1, theClassToMonitor.methodsToInstrument().size());
        
        theClassToMonitor.methodsToInstrument().add("toto");
    }
}
