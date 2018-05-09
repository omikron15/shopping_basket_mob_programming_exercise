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
    Food foodTwo;
    LoyaltyCard loyaltyCard;
    Customer customer;

    @Before
    public void before() {
        loyaltyCard = new LoyaltyCard();
        customer = new Customer();
        food = new Food("Doughnut", 0.80);
        foodTwo = new Food("Doughnut", 0.80);
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

    @Test
    public void canRemoveProduct() {
        basket.addProduct(food);
        basket.removeProduct(food);
        assertEquals(0, basket.getNumberOfProducts());
    }

    @Test
    public void canClearBasketOfAllItems() {
        basket.addProduct(food);
        basket.addProduct(food);
        basket.clearBasket();
        assertEquals(0, basket.getNumberOfProducts());
    }

    @Test
    public void canGetUpdatedTotal() {
        basket.addProduct(food);
        basket.calculateTotal();
        assertEquals(0.80, basket.getTotal(), 0.01);
    }


    @Test
    public void canGetTotalAfterBOGOFDiscount() {
        basket.addProduct(food);
        basket.addProduct(foodTwo);
        basket.addProduct(food);
        assertEquals(1.60, basket.bogofDiscount(basket.getTotal()), 0.01);
    }

}
