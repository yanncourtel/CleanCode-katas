package zenika.supple.seff;

public class PaymentQueue {

    private static PaymentQueue instance;

    public static void enqueuePayment(String cardNumber, int amount) {
        instance.enqueue(cardNumber, amount);    
    }

    private void enqueue(String cardNumber, int amount) {
        System.out.printf("Debit enqueued: %s by %d%n", cardNumber, amount);
    }

    public static void init() {
        instance = new PaymentQueue();
        String queueStarted = String.format("Payment queue started: %s%n", instance);
        PaymentEventsDatabase.recordPaymentEvent(queueStarted);
    }
}
