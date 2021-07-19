package zenika.supple.sym;

public interface MutableMonetaryAmount {

    void add(MutableMonetaryAmount that);

    void subtract(MutableMonetaryAmount that);

}
