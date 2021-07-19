package zenika.supple.vo;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableSet;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static zenika.supple.vo.MonetaryAmount.*;

public class MonetaryAmountTest {

    private final MonetaryAmount
            euros100 = new MonetaryAmount(100, "EUR"),
            euros150 = new MonetaryAmount(150, "EUR"),
            euros200 = new MonetaryAmount(200, "EUR"),
            euros1000 = new MonetaryAmount(1000, "EUR"),
            dollars100 = new MonetaryAmount(100, "USD");

    private final Rates rates = mock(Rates.class);;
    @Before public void setupRates() {
        when(rates.from("EUR")).thenReturn(usd -> 2.0);
        when(rates.from("USD")).thenReturn(eur -> 0.5);
    }

    @Test public void twice_100_euros_should_be_200_euros() {
        assertEquals(euros200, euros100.times(2));
    }

    @Test public void _100_euros_plus_0_euros_should_be_100_euros() {//TODO reduce avec cet elt neutre
        assertEquals(euros100, euros100.plus(ZERO_EUROS));
    }

    @Test public void _100_euros_plus_100_euros_should_be_200_euros() {
        assertEquals(euros200, euros100.plus(euros100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void _100_euros_plus_100_dollars_should_throw_without_target_currency() {
        euros100.plus(dollars100);
    }

    @Test public void _100_euros_plus_100_dollars_should_be_150_euros() {
        assertEquals(euros150, euros100.plus(dollars100, rates));
    }

    //Bonus: reduce et collect
    @Test public void sum_of_amounts_by_reduction() {
        Set<MonetaryAmount> amounts = asSet(
                euros100, euros150, euros200, euros1000
        );
        MonetaryAmount sum = amounts.stream().reduce(
                ZERO_EUROS,
                MonetaryAmount::plus
        );
        assertEquals(sum, new MonetaryAmount(1450, "EUR"));
    }

    @Test public void sum_of_amounts_by_collection1() {
        Set<MonetaryAmount> amounts = asSet(
                euros100, euros150, euros200, euros1000
        );
        MonetaryAmount sum = amounts.stream().collect(summingMonetaryAmount1());
        assertEquals(new MonetaryAmount(1450, "EUR"), sum);
    }

    @Test public void sum_of_amounts_by_collection2() {
        Set<MonetaryAmount> amounts = asSet(
                euros100, euros150, euros200, euros1000
        );
        MonetaryAmount sum = amounts.stream().collect(summingMonetaryAmount2());
        assertEquals(new MonetaryAmount(1450, "EUR"), sum);
    }

    @SafeVarargs @SuppressWarnings("varargs")
    private static <T> Set<T> asSet(T... elts) {
        return unmodifiableSet(new HashSet<>(asList(elts)));
    }
}
