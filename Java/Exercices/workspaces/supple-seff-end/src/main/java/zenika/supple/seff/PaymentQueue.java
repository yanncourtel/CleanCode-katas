package zenika.supple.seff;

import static java.util.Objects.requireNonNull;

public class PaymentQueue {

    public PaymentQueue(PaymentEventsDatabase paymentEventsDatabase) {
        requireNonNull(paymentEventsDatabase);
        paymentEventsDatabase.recordPaymentEvent(String.format("Payment queue started: %s%n", this));
    }

    public void enqueuePayment(String cardNumber, int amount) {
        System.out.printf("Debit enqueued: %s by %d%n", cardNumber, amount);
    }

}
