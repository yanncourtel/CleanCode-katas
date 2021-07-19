package zenika.rappel.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Predicate;

import static java.lang.System.out;
import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.nullsLast;
import static org.junit.Assert.assertTrue;

public class LambdasTest
{
    private static List<Person> persons() {
        return Arrays.asList(
            new Person("toto"),
            new Person("tata"),
            new Person("titi")
        );
    }

    private static List<Person> personsWithNull() {
        return Arrays.asList(
                new Person("toto"),
                new Person("tata"),
                new Person(null),
                new Person("titi")
        );
    }

    @Test
    public void runnable() {
        Runnable r = new Runnable() {
            @Override
            public void run() {

            }
        };

        //Curseur sur "new Runnable", ALT+ENTER "Replace with lambda
    }

    @Test
    public void function() {
        Function<String, Integer> stringLength = (String s) -> {
            //do stuff
            //do more stuff
            return s.length();
        };
        stringLength = s -> {
            //do stuff
            //do more stuff
            return s.length();
        };
        stringLength = s -> s.length();
        stringLength = String::length;
        out.printf(
                "stringLength.apply(\"toto\"): %s%n",
                stringLength.apply("toto")
        );
    }

    @Test
    public void consumer() {
        Consumer<String> printer = s -> out.println("hello from printer, "+s);
        printer.accept("toto");
    }

    @Test
    public void supplier() {
        IntSupplier randomInts = () -> ThreadLocalRandom.current().nextInt();
        out.printf(
            "randomInts.getAsInt(): %s%n",
            randomInts.getAsInt()
        );
    }

    @Test
    public void predicate() {
        Predicate<String> isAlpha = s -> s.matches("[a-zA-Z]+");
        out.printf(
            "isAlpha.test(\"toto\"): %s, isAlpha.test(\"59\"): %s%n",
            isAlpha.test("toto"),
            isAlpha.test("59")
        );
        Predicate<String> isNum = s -> s.matches("[0-9]+");
        out.printf(
            "isNum.test(\"59\"): %s, isNum.test(\"toto\"): %s%n",
            isNum.test("59"),
            isNum.test("toto")
        );
        Predicate<String> isNumOrAlpha = isAlpha.or(isNum);
        out.printf(
            "isNumOrAlpha.test(\"toto\"): %s, isNumOrAlpha.test(\"59\"): %s%n",
            isNumOrAlpha.test("toto"),
            isNumOrAlpha.test("59")
        );
    }

    @Test
    public void comparator() {
        List<Person> persons;

        persons = persons();
        out.println("BEFORE sort: " + persons);
        persons.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        out.println("AFTER sort: " + persons);

        persons = persons();
        out.println("BEFORE sort 2: " + persons);
        persons.sort((p1, p2) -> p1.getName().compareTo(p2.getName())); //NullPointerException
        out.println("AFTER sort 2: " + persons);

        persons = persons();
        out.println("BEFORE sort 3: " + persons);
        persons.sort(comparing(Person::getName));
        out.println("AFTER sort 3: " + persons);

        persons = personsWithNull();
        out.println("BEFORE sort 4: " + persons);
        persons.sort(comparing(
            Person::getName,
            nullsLast(naturalOrder())
        ));
        out.println("AFTER sort 4: " + persons);
        assertTrue( true );
    }
}
