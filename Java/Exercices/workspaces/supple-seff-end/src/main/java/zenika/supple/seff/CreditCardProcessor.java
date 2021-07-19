package zenika.supple.seff;

import static java.util.Objects.requireNonNull;

public class CreditCardProcessor {

    private final PaymentEventsDatabase paymentEventsDatabase;
    private final PaymentQueue paymentQueue;

    public CreditCardProcessor(PaymentEventsDatabase paymentEventsDatabase, PaymentQueue paymentQueue) {
        this.paymentEventsDatabase = requireNonNull(paymentEventsDatabase);
        this.paymentQueue = requireNonNull(paymentQueue);
    }

    public void charge(String cardNumber, int amount) {
        String paymentEvent = String.format("Debit %s by %d%n", cardNumber, amount);
        paymentEventsDatabase.recordPaymentEvent(paymentEvent);
        paymentQueue.enqueuePayment(cardNumber, amount);
    }

}
