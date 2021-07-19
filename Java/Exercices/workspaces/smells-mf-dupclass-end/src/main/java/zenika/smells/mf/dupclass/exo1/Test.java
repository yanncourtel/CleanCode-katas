package zenika.smells.mf.dupclass.exo1;

public abstract class Test {
    
    final void test() {
        setup();
        try {
            exercise();
        } finally {
            teardown();
        }
    }

    protected abstract void setup();

    protected abstract void exercise();
    
    protected abstract void teardown();
}
