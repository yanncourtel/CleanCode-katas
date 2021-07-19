package zenika.supple.seff;

public class PaymentEventsDatabase {

    private static PaymentEventsDatabase instance;

    public static void recordPaymentEvent(String paymentEvent) {
        instance.save(paymentEvent);    
    }

    private void save(String paymentEvent) {
        System.out.printf(paymentEvent);
    }

    public static void init() {
        instance = new PaymentEventsDatabase();
    }
}
