package zenika.smells.mf.dupclass.exo1;

public class Service2Test extends Test {
    
    private Service2 service2;  
    
    @Override protected void setup() {
        service2 = new Service2();
    }

    @Override protected void exercise() {
        assert service2.doIt() == Service2.Outcome.SUCCESS;
    }
    
    @Override protected void teardown() {
        service2.destroy();
    }
}
