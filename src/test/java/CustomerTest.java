import customers.Customer;
import customers.LoyaltyCard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    LoyaltyCard loyaltyCard;
    Customer customer;

    @Before
    public void before() {
        loyaltyCard = new LoyaltyCard();
        customer = new Customer();
    }

    @Test
    public void startsWithoutLoyaltyCard() {
        assertEquals(false, customer.hasLoyaltyCard());
    }

    @Test
    public void canAddLoyaltyCard() {
        customer.addLoyaltyCard(loyaltyCard);
        assertEquals(true, customer.hasLoyaltyCard());
    }
}
