import customers.Customer;
import customers.LoyaltyCard;
import org.junit.Before;
import org.junit.Test;
import products.Food;
import shop.Basket;

import static org.junit.Assert.assertEquals;

public class BasketTest {

    Basket basket;
    Basket basket2;
    Food food;
    Food foodTwo;
    Food food3;
    Food food4;
    LoyaltyCard loyaltyCard;
    Customer customer;
    Customer customer2;

    @Before
    public void before() {
        loyaltyCard = new LoyaltyCard();
        customer = new Customer();
        customer2 = new Customer();
        customer.addLoyaltyCard(loyaltyCard);

        food = new Food("Doughnut", 0.80);
        foodTwo = new Food("Doughnut", 0.80);
        food3 = new Food("Doughnut", 100.00);
        food4 = new Food("Doughnut", 20);
        basket = new Basket(customer);
        basket2 = new Basket(customer2);
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
        basket2.addProduct(food);
        basket2.calculateTotal();
        assertEquals(0.8, basket2.getTotal(), 0.01);
    }


    @Test
    public void canGetTotalAfterBOGOFDiscount() {
        basket.addProduct(food);
        basket.addProduct(foodTwo);
        basket.addProduct(food);
        assertEquals(1.60, basket.bogofDiscount(basket.getTotal()), 0.01);
    }

    @Test
    public void canGetTenPercentOff() {
        basket2.addProduct(food3);
        basket2.calculateTotal();
        assertEquals(90.00, basket2.getTotal(), 0.01);
    }

    @Test
    public void canGetTwoPercentOff__withLoyaltyCard() {
        basket.addProduct(food4);
        basket.calculateTotal();
        assertEquals(19.60, basket.getTotal(), 0.01);
    }

    @Test
    public void canGetTwoPercentOff__noLoyaltyCard() {
        basket2.addProduct(food4);
        basket2.calculateTotal();
        assertEquals(20.00, basket2.getTotal(), 0.01);
    }

    @Test
    public void BigTest() {
        basket.addProduct(food3);
        basket.calculateTotal();
        assertEquals(88.20, basket.getTotal(), 0.1);
    }

    @Test
    public void BigTest2() {
        basket.addProduct(food3);
        basket.addProduct(food3);
        basket.calculateTotal();
        assertEquals(88.20, basket.getTotal(), 0.1);
    }

    @Test
    public void BigTest3() {
        basket.addProduct(food3);
        basket.addProduct(food3);
        basket.addProduct(food3);
        basket.calculateTotal();
        assertEquals(176.4, basket.getTotal(), 0.1);
    }

}
