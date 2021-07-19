package zenika.smells.uneffjava.immut;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class MonitoredClassTest {
    
    @Test public void monitored_methods_should_be_immutable_1() {
        //Lu depuis un fichier de conf, 
        // qui déclare quelles classes doivent être instrumentées (ajout logs de perfs) 
        String theClassNameToMonitor = "com.enterprise.booking.ReserverSalle"; 
        Set<String> theMethodNamesToMonitor = new HashSet<String>(){{add("reserver");}};
        
        MonitoredClass theClassToMonitor = new MonitoredClass(theClassNameToMonitor, theMethodNamesToMonitor);
        assertEquals(1, theClassToMonitor.methodsToInstrument().size());
        
        theMethodNamesToMonitor.add("toto");
        assertEquals(1, theClassToMonitor.methodsToInstrument().size());
    }
    
    @Test(expected = UnsupportedOperationException.class) 
    public void monitored_methods_should_be_immutable_2() {
        //Lu depuis un fichier de conf, 
        // qui déclare quelles classes doivent être instrumentées (ajout logs de perfs)
        String theClassNameToMonitor = "com.enterprise.booking.ReserverSalle"; 
        Set<String> theMethodNamesToMonitor = new HashSet<String>(){{add("reserver");}};
        
        MonitoredClass theClassToMonitor = new MonitoredClass(theClassNameToMonitor, theMethodNamesToMonitor);
        assertEquals(1, theClassToMonitor.methodsToInstrument().size());
        
        theClassToMonitor.methodsToInstrument().add("toto");
    }
}
