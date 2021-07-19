package zenika.supple.seff;

public class CreditCardProcessor {

    private static CreditCardProcessor instance;

    public static void charge(String cardNumber, int amount) {
        instance.debit(cardNumber, amount);        
    }

    private void debit(String cardNumber, int amount) {
        String paymentEvent = String.format("Debit %s by %d%n", cardNumber, amount);
        PaymentEventsDatabase.recordPaymentEvent(paymentEvent);
        PaymentQueue.enqueuePayment(cardNumber, amount);
    }

    public static void init() {
        instance = new CreditCardProcessor();
    }
}
