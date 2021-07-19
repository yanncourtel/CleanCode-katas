package zenika.supple.seff;

import org.junit.Test;

public class CreditCardTest {
    
    @Test public void can_charge_credit_card_attempt1() {
        CreditCard card =  new CreditCard("1111 2222 3333 4444", 12, 2020);
        card.charge(100);
    }
    
    @Test public void can_charge_credit_card_attempt2() {
        PaymentQueue.init();
        CreditCardProcessor.init();
        CreditCard card =  new CreditCard("1111 2222 3333 4444", 12, 2020);
        card.charge(100);
    }
    
    @Test public void can_charge_credit_card_attempt3() {
        PaymentQueue.init();
        PaymentEventsDatabase.init();
        CreditCardProcessor.init();
        CreditCard card =  new CreditCard("1111 2222 3333 4444", 12, 2020);
        card.charge(100);
    }
    
    @Test public void can_charge_credit_card_attempt4() {
        PaymentEventsDatabase.init();
        PaymentQueue.init();
        CreditCardProcessor.init();
        CreditCard card =  new CreditCard("1111 2222 3333 4444", 12, 2020);
        card.charge(100);
    }
}
