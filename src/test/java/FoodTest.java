import org.junit.Before;
import org.junit.Test;
import products.Food;

import static org.junit.Assert.assertEquals;

public class FoodTest {

    Food food;

    @Before
    public void before() {
        food = new Food("Doughnut", 0.80);
    }

    @Test
    public void canGetName() {
        assertEquals("Doughnut", food.getName());
    }

    @Test
    public void canGetPrice() {
        assertEquals(0.80, food.getPrice(), 0.01);
    }
}
