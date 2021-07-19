package zenika.supple.vo;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collector;

import static java.lang.String.format;
import static java.util.Objects.hash;
import static java.util.Objects.requireNonNull;
import static java.util.function.Function.identity;
import static java.util.regex.Pattern.compile;
import static java.util.stream.Collector.Characteristics.*;
import static java.util.stream.Collectors.reducing;

/**
 * Le but est juste de montrer l'interet des VOs en relation avec 2 principes Supple Design:
 *  -Standalone Classes (mm si ici on ne respecte pas tt a fait le standalone..)
 *  -Closure of Operations
 * En réalité il faudrait utiliser java.util.Currency ou directement Joda Money.
 * De plus on ne se préoccupe pas des centimes, c'est l'occasion de signaler:
 *  -Qu'il ne faut pas utiliser les binary floating point pour des calculs exacts
 *  -Qu'il faut utiliser soit des centimes soit BigDecimal
 *  -Joda Money directement c'est encore plus simple
 */
public class MonetaryAmount {

    private static final Pattern CURRENCY_CODE = compile("[A-Z]{3}");
    public static final MonetaryAmount ZERO_EUROS = new MonetaryAmount(0, "EUR");

    private final int amount;
    private final String currencyCode;

    public MonetaryAmount(int amount, String currencyCode) {
        this.amount = amount;
        this.currencyCode = requireNonNull(currencyCode);
        validate();
    }

    private void validate() {
        if(amount < 0) throw new IllegalArgumentException(format(
            "amount(%d) must not be negative", amount
        ));
        if(!CURRENCY_CODE.matcher(currencyCode).matches()) throw new IllegalArgumentException(format(
            "currencyCode(%s) must be 3 uppercase ascii letters", amount
        ));
    }

    public boolean isBiggerThan(MonetaryAmount b, Rates r) {
        double rate = r.from(b.currencyCode).to(this.currencyCode);
        int otherBidAmountInSameCurrency = (int) Math.round(b.amount * rate);
        return this.amount >= otherBidAmountInSameCurrency;
    }

    @Override public String toString() {
        return format("%d %s", amount, currencyCode);
    }

    @Override public boolean equals(Object obj) {
        if(!(obj instanceof MonetaryAmount)) return false;
        MonetaryAmount that = (MonetaryAmount) obj;

        if(!Objects.equals(this.amount, that.amount)) return false;
        if(!Objects.equals(this.currencyCode, that.currencyCode)) return false;
        return true;
    }

    @Override public int hashCode() {
        return hash(amount, currencyCode);
    }

    public MonetaryAmount plus(MonetaryAmount that) {
        if(!this.currencyCode.equals(that.currencyCode)) throw new IllegalArgumentException(format(
                "L'addition de devises hétérogènes est illégal. Utiliser plus(that, rates, targetCurrency)."
        ));
        return new MonetaryAmount(
                Math.addExact(this.amount, that.amount), //check overflow
                this.currencyCode
        );
    }

    public MonetaryAmount times(int times) {
        return new MonetaryAmount(
                Math.multiplyExact(this.amount, times), //check overflow
                this.currencyCode
        );
    }

    public MonetaryAmount plus(MonetaryAmount that, Rates rates) {
        double rate = rates.from(this.currencyCode).to(that.currencyCode);
        return new MonetaryAmount(
                Math.addExact(
                        this.amount,
                        (int) Math.round(that.amount / rate)
                ),
                this.currencyCode
        );
    }

    //bonus
    public static Collector<MonetaryAmount, ?, MonetaryAmount> summingMonetaryAmount1() {
        return reducing(ZERO_EUROS, MonetaryAmount::plus);
    }

    public static Collector<MonetaryAmount, ?, MonetaryAmount> summingMonetaryAmount2() {
        return new SummingMonetaryAmount();
    }

    private static class SummingMonetaryAmount implements Collector<MonetaryAmount, MutableMonetaryAmount, MonetaryAmount> {

        @Override public Supplier<MutableMonetaryAmount> supplier() {
            return () -> MutableMonetaryAmount.of(ZERO_EUROS);
        }

        @Override public BiConsumer<MutableMonetaryAmount, MonetaryAmount> accumulator() {
            return MutableMonetaryAmount::add;
        }

        @Override public BinaryOperator<MutableMonetaryAmount> combiner() {
            return MutableMonetaryAmount::add;
        }

        @Override public Function<MutableMonetaryAmount, MonetaryAmount> finisher() {
            return MutableMonetaryAmount::asImmutable;
        }

        @Override public Set<Characteristics> characteristics() {
            return EnumSet.of(CONCURRENT, UNORDERED);
        }
    }

    private static class MutableMonetaryAmount {
        private int amount;
        private final String currencyCode;

        public MutableMonetaryAmount(int amount, String currencyCode) {
            this.amount = amount;
            this.currencyCode = currencyCode;
        }

        public void add(MonetaryAmount that) {
            this.amount = Math.addExact(this.amount, that.amount);
        }

        public MutableMonetaryAmount add(MutableMonetaryAmount that) {
            return new MutableMonetaryAmount(Math.addExact(this.amount, that.amount), this.currencyCode);
        }

        public MonetaryAmount asImmutable() {
            return new MonetaryAmount(this.amount, this.currencyCode);
        }

        public static MutableMonetaryAmount of(MonetaryAmount immutableAmount) {
            return new MutableMonetaryAmount(immutableAmount.amount, immutableAmount.currencyCode);
        }

    }
}
