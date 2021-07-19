package zenika.solid.dip.infrastructure;

public class AvailabilityDaoImpl implements AvailabilityDao {
    
    @Override public boolean isAvailable() {
        //En realite il y aurait une dependance vers JPA/Hib/un WS...
        return true; 
    }
    
}
