package zenika.smells.mf.dupclass.exo1;

public class Service1Test {
    
    private Service1 service1;  
    
    void test() {
        setup();
        try {
            exercise();
        } finally {
            teardown();
        }
    }

    private void setup() {
        service1 = new Service1();
    }

    private void exercise() {
        assert service1.doIt() == Service1.Outcome.SUCCESS;
    }
    
    private void teardown() {
        service1.destroy();
    }
}
