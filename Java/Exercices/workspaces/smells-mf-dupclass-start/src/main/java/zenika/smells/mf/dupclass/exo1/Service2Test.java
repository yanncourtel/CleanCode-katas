package zenika.smells.mf.dupclass.exo1;

public class Service2Test {
    
    private Service2 service2;  
    
    void test() {
        setup();
        try {
            exercise();
        } finally {
            teardown();
        }
    }

    private void setup() {
        service2 = new Service2();
    }

    private void exercise() {
        assert service2.doIt() == Service2.Outcome.SUCCESS;
    }
    
    private void teardown() {
        service2.destroy();
    }
}
