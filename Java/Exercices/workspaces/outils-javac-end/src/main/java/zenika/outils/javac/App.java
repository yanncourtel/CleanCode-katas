package zenika.outils.javac;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    private List rawList;
    private static App app = new App();

    public static void main( String[] args )
    {
        System.out.println("Hello Warning World!");

        String s = (String)"Hello!";


        if (1==0);
            System.out.println("1 == 0 !!!!!");

        switch (1) {
            case 1:
                   System.out.println("case 1");
            case 2:
                   System.out.println("case 2");
        }

        app.staticMethod();

        List numbers = new ArrayList<Number>();
        List<String> strings = numbers;

        Thread.currentThread().stop();
    }

    public static boolean notSure() {
        try {
          return true;
        } finally {
          return false;
        }
    }

    public boolean equals(App obj) {
        return super.equals(obj);
    }

    static void staticMethod() { }
}
