package zenika.supple.seff;

import static java.util.Objects.requireNonNull;

public class CreditCard {

    private final String cardNumber;
    private final int expiryMonth;
    private final int expiryYear;

    public CreditCard(String cardNumber, int expiryMonth, int expiryYear) {
        this.cardNumber = cardNumber;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
    }

    public void charge(int amount, CreditCardProcessor processor) {
        requireNonNull(processor);
        processor.charge(cardNumber, amount);
    }
}
