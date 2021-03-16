package ie.gmit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemTest {
    private Item i1;

    @BeforeEach
    void init(){i1 = new Item("Name", 3.33, 14);}

    @Test
    public void testItemCreateSuccess(){
        assertEquals(i1, i1);
    }

    @Test
    public void testConstructorNameFail(){
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                new Item("A", 3.33, 14));
        assertEquals("Invalid Name", e.getMessage());
    }

    @Test
    public void testConstructorPriceFail(){
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                new Item("Name", -3.33, 14));
        assertEquals("Invalid Price", e.getMessage());
    }

    @Test
    public void testConstructorQuantityFail(){
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                new Item("Name", 3.33, 0));
        assertEquals("Invalid Quantity", e.getMessage());
    }
}
