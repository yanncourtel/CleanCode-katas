package zenika.supple.vo;

public interface Rates {
    RateBuilder from(String currencyCode);

    interface RateBuilder {
        double to(String currencyCode);//double c'est pas bien..
    }
}
