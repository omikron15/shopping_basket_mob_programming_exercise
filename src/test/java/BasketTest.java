import customers.Customer;
import customers.LoyaltyCard;
import org.junit.Before;
import org.junit.Test;
import products.Food;
import shop.Basket;

import static org.junit.Assert.assertEquals;

public class BasketTest {

    Basket basket;
    Food food;
    LoyaltyCard loyaltyCard;
    Customer customer;

    @Before
    public void before() {
        loyaltyCard = new LoyaltyCard();
        customer = new Customer();
        food = new Food("Doughnut", 0.80);
        basket = new Basket();
    }

    @Test
    public void totalStartsAt0() {
        assertEquals(0.0, basket.getTotal(), 0.1);
    }

    @Test
    public void productsStartEmpty() {
        assertEquals(0, basket.getNumberOfProducts());
    }

    @Test
    public void canAddProduct() {
        basket.addProduct(food);
        assertEquals(1, basket.getNumberOfProducts());
    }
}
