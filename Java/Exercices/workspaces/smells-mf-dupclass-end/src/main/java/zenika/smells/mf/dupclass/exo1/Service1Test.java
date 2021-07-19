package zenika.smells.mf.dupclass.exo1;

public class Service1Test extends Test {
    
    private Service1 service1;  
    
    @Override protected void setup() {
        service1 = new Service1();
    }

    @Override protected void exercise() {
        assert service1.doIt() == Service1.Outcome.SUCCESS;
    }
    
    @Override protected void teardown() {
        service1.destroy();
    }
}
