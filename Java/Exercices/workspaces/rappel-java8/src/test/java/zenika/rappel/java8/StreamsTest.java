package zenika.rappel.java8;

import org.junit.Test;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.*;
import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.collectingAndThen;
import static org.assertj.core.api.Assertions.*;

public class StreamsTest
{
    private final Book effectiveJava = Book.named("Effective Java")
        .about(Topic.COMPUTING)
        .havingPages(350)
        .writtenBy("Neal Gafter", "Josh Bloch")
        .build();
    private final Book javaConcurrencyInPractice = Book.named("Java Concurrency in Practice")
        .about(Topic.COMPUTING)
        .havingPages(400)
        .writtenBy("Brian Goetz", "Doug Lea", "Josh Bloch")
        .build();
    private final Book recetteGrandMeres = Book.named("Les recettes de mes grand-mères")
        .about(Topic.COOKING)
        .havingPages(200)
        .writtenBy("Tati gateau")
        .build();
    private final Set<Book> library = unmodifiableSet(new HashSet<>(
        asList(effectiveJava, recetteGrandMeres, javaConcurrencyInPractice))
    );


    @Test public void filter() {
        Set<Book> computingBooks = library.stream()
            .filter(book -> book.getTopic() == Topic.COMPUTING)
            .collect(toSet());

        assertThat(computingBooks)
            .contains(effectiveJava)
            .contains(javaConcurrencyInPractice)
            .doesNotContain(recetteGrandMeres);
    }

    @Test public void map() {
        Set<String> titles = library.stream()
            .map(Book::getTitle)
            .collect(toSet());

        assertThat(titles).contains(
            "Effective Java",
            "Les recettes de mes grand-mères",
            "Java Concurrency in Practice"
        );
    }

    @Test public void collect() {
        IntSummaryStatistics booksPagesStats = library.stream()
            .collect(
                summarizingInt(Book::getPages)
            );

        assertThat(booksPagesStats.getMax()).isEqualTo(400);
        assertThat(booksPagesStats.getMin()).isEqualTo(200);
    }

    @Test public void filter_map_reduce() {
        int totalComputingPages = library.stream()
            .filter(book -> book.getTopic() == Topic.COMPUTING)
            .mapToInt(Book::getPages)
            .sum();

        assertThat(totalComputingPages).isEqualTo(750);
    }

    @Test public void filter_map_reduce_DEPRECATED() {
        //Meme si Predicate Guava:
        // -plus verbeux
        // -une classe anonyme par predicat
        // -une instance du predicat a chq execution de la methode
        List<Book> allComputingBooks = new ArrayList<>();
        for(Book book : library) {
            if(book.getTopic() == Topic.COMPUTING){
                allComputingBooks.add(book);
            }
        }

        int totalComputingPages = 0;
        for(Book book : allComputingBooks) {
            totalComputingPages += book.getPages();
        }

        assertThat(totalComputingPages).isEqualTo(750);
    }

    @Test public void flatMap() {
        //nested loops = deprecated
        Set<String> allAuthors = library.stream()
            .flatMap(book -> book.getAuthors().stream())
            .collect(toSet());

        assertThat(allAuthors)
            .hasSize(5)
            .contains("Josh Bloch")
            .contains("Neal Gafter")
            .contains("Brian Goetz")
            .contains("Doug Lea")
            .contains("Tati gateau");
    }

    @Test public void flatMapAndFilter() {
        Set<String> authorsNamedJSomething;

        authorsNamedJSomething = library.stream()
            .flatMap(book -> book.getAuthors().stream())
            .filter(author -> author.startsWith("J"))
            .collect(toSet());
        assertThat(authorsNamedJSomething).containsExactly("Josh Bloch");

        authorsNamedJSomething = library.stream()
            .flatMap(book ->
                book.getAuthors().stream().filter(
                        auth -> auth.startsWith("J")
                )
            )
            .collect(toSet());
        assertThat(authorsNamedJSomething).containsExactly("Josh Bloch");
    }

    @Test public void intRangeBasic() {
        int sum;

        sum = IntStream.rangeClosed(0, 10).sum();
        assertThat(sum).isEqualTo(55);

        sum = IntStream.rangeClosed(0, 10).reduce(0, (i, j) -> i + j);
        assertThat(sum).isEqualTo(55);

        sum = IntStream.rangeClosed(0, 10).reduce(0, Integer::sum);
        assertThat(sum).isEqualTo(55);
    }

    @Test public void pointsOfSquare() {
        int POINTS_PER_SIDE = 10;

        Stream<Point> points = IntStream.range(0, POINTS_PER_SIDE).mapToObj(
                x -> IntStream.range(0, POINTS_PER_SIDE).mapToObj(
                        y -> new Point(x, y)
                )
        ).flatMap(identity());


        Set<Point> allPoints = points.collect(toSet());
        assertThat(allPoints).hasSize(100);
        assertThat(allPoints.stream().anyMatch(p -> p.x == 0 && p.y == 0)).isTrue();
        assertThat(allPoints.stream().anyMatch(p -> p.x == 9 && p.y == 9)).isTrue();
        assertThat(allPoints.stream().anyMatch(p -> p.x == 0 && p.y == 9)).isTrue();
        assertThat(allPoints.stream().anyMatch(p -> p.x == 9 && p.y == 0)).isTrue();
    }

    @Test public void simpleCollect_naturalOrder() {
        SortedSet<String> authorsDesc = library.stream()
            .flatMap(book -> book.getAuthors().stream())
            .collect(toCollection(TreeSet::new));
        assertThat(authorsDesc).containsExactly(
            "Brian Goetz",
            "Doug Lea",
            "Josh Bloch",
            "Neal Gafter",
            "Tati gateau"
        );
    }

    @Test public void simpleCollect_contextualOrder() {
        SortedSet<Book> byPagesDesc = library.stream()
            .collect(toCollection(
                    () -> new TreeSet<>(
                        comparing(Book::getPages).reversed()
                    )
            ));
        //On peut indenter, ca reste une seule EXPRESSION,
        // et non une suite de STATEMENTS comme ds l'antipattern escalier
        //Donc pas de pb car bcp plus facile a se representer
        //Si ca vous gene au debut, vous pouvez separer les expressions
        // mais c'est idiomatique de tout chainer
        assertThat(byPagesDesc).containsExactly(
            javaConcurrencyInPractice,
            effectiveJava,
            recetteGrandMeres
        );
    }

    @Test public void collect_joining() {
        String authors = library.stream()
            .flatMap(b -> b.getAuthors().stream())
            .sorted()
            .collect(joining(", ", "[", "]"));

        assertThat(authors).isEqualTo(
            "[Brian Goetz, Doug Lea, Josh Bloch, Josh Bloch, Neal Gafter, Tati gateau]"
        );
    }

    @Test public void partition() {
        Map<Boolean, List<Book>> computingSubjectPartition = library.stream()
            .collect(partitioningBy(
                book -> book.getTopic() == Topic.COMPUTING
            ));

        assertThat(computingSubjectPartition.get(true)).contains(effectiveJava).contains(javaConcurrencyInPractice);
        assertThat(computingSubjectPartition.get(false)).containsExactly(recetteGrandMeres);
    }

    @Test public void partition_withDownstream() {
       Map<Boolean, Set<Book>> computingSubjectPartition = library.stream()
            .collect(partitioningBy(
                    book -> book.getTopic() == Topic.COMPUTING,
                    toSet()
            ));

        assertThat(computingSubjectPartition.get(true))
                .contains(effectiveJava)
                .contains(javaConcurrencyInPractice);
        assertThat(computingSubjectPartition.get(false))
                .containsExactly(recetteGrandMeres);
    }

    @Test public void groupBy() {
        Map<Topic, List<Book>> bySubject = library.stream()
            .collect(groupingBy(Book::getTopic));

        assertThat(bySubject.get(Topic.COMPUTING))
                .contains(effectiveJava)
                .contains(javaConcurrencyInPractice);
        assertThat(bySubject.get(Topic.COOKING))
                .containsExactly(recetteGrandMeres);
    }

    @Test public void groupBy_downstreamCollector1() {
        Map<Topic, Long> bySubject = library.stream()
            .collect(groupingBy(
                Book::getTopic,
                counting()
            ));

        assertThat(bySubject.get(Topic.COMPUTING)).isEqualTo(2L);
        assertThat(bySubject.get(Topic.COOKING)).isEqualTo(1L);
    }

    @Test public void groupBy_downstreamCollector2() {
        Map<Topic, Set<Book>> bySubject = library.stream()
            .collect(groupingBy(
                Book::getTopic,
                toSet()
            ));

        assertThat(bySubject.get(Topic.COMPUTING))
                .contains(effectiveJava)
                .contains(javaConcurrencyInPractice);
        assertThat(bySubject.get(Topic.COOKING))
                .containsExactly(recetteGrandMeres);
    }

    @Test public void groupBy_downstreamCollector3() {
        Map<Topic, String> titlesByTopic = library.stream()
            .sorted(comparing(Book::getTitle))
            .collect(groupingBy(
                    Book::getTopic,
                    mapping(
                            Book::getTitle,
                            joining("; ")
                    )
            ));

        assertThat(titlesByTopic.get(Topic.COMPUTING)).isEqualTo(
            "Effective Java; Java Concurrency in Practice"
        );
        assertThat(titlesByTopic.get(Topic.COOKING)).isEqualTo(
            "Les recettes de mes grand-mères"
        );
    }

    @Test public void finisher() {
        Map<Topic, Set<Book>> bySubject = library.stream().collect(groupingBy(
                Book::getTopic,
                collectingAndThen(
                        toSet(),
                        Collections::unmodifiableSet
                )
        ));

        Set<Book> computingBooks = bySubject.get(Topic.COMPUTING);
        Book anotherBook = Book.named("PHP in action").build();

        try {
            computingBooks.add(anotherBook);
            fail("Should throw UnsupportedOperationException");
        } catch(UnsupportedOperationException expected) {}
    }

    @Test public void finisher2() {
        Map<Topic, Book> longestBookByTopic = library.stream().collect(groupingBy(
                Book::getTopic,
                collectingAndThen(
                        maxBy(comparingInt(Book::getPages)),
                        Optional::get
                )
        ));

        assertThat(longestBookByTopic.get(Topic.COMPUTING))
                .isEqualTo(javaConcurrencyInPractice);
        assertThat(longestBookByTopic.get(Topic.COOKING))
                .isEqualTo(recetteGrandMeres);
    }

    @Test public void collectVsReduce() {
        int sum;

        sum = IntStream.rangeClosed(0, 10).sum();
        assertThat(sum).isEqualTo(55);

        sum = IntStream.rangeClosed(0, 10).reduce(0, (i, j) -> i + j);
        assertThat(sum).isEqualTo(55);

        sum = IntStream.rangeClosed(0, 10).reduce(0, Integer::sum);
        assertThat(sum).isEqualTo(55);

        sum = IntStream.rangeClosed(0, 10).boxed().collect(
                reducing(0, Integer::sum)
        );
        assertThat(sum).isEqualTo(55);

        sum = IntStream.rangeClosed(0, 10).boxed().reduce(
            0,                   //identity
            (a, s)   -> a  + s,  //accumulator
            (s1, s2) -> s1 + s2  //combiner
        );
        assertThat(sum).isEqualTo(55);

        sum = IntStream.rangeClosed(0, 10).boxed().collect(
                () -> new AtomicInteger(0), //identity
                (s, i) -> s.addAndGet(i),   //accumulator
                (s1, s2) -> s1.addAndGet(s2.get()) //combiner
        ).get();
        assertThat(sum).isEqualTo(55);
    }
}
