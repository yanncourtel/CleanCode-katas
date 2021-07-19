namespace SOLID.DependencyInversion.infrastructure
{
    public class AvailabilityDaoImpl : IAvailabilityDao {
    
        public virtual bool IsAvailable() {
            //En realite il y aurait une dependance vers une base de donnéesS...
            return true; 
        }
    
    }
}
