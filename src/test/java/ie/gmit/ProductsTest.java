package ie.gmit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductsTest {
    private Products p1;

    @BeforeEach
    void init(){p1 = new Products("Name", 3.33, 14, "P0254672");}

    @Test
    public void testItemCreateSuccess(){
        assertEquals("Name", p1.getName());
        assertEquals(3.33, p1.getPrice());
        assertEquals(14, p1.getQuantity());
        assertEquals("P0254672", p1.getProductID());
    }

    @Test
    public void testConstructorNameFail(){
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                new Products("A", 3.33, 14, "P0254672"));
        assertEquals("Invalid Name", e.getMessage());
    }

    @Test
    public void testConstructorPriceFail(){
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                new Products("Name", -3.33, 14,"P0254672"));
        assertEquals("Invalid Price", e.getMessage());
    }

    @Test
    public void testConstructorQuantityFail(){
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                new Products("Name", 3.33, 0,"P0254672"));
        assertEquals("Invalid Quantity", e.getMessage());
    }

    @Test
    public void testConstructorProductIDFail(){
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                new Products("Name", 3.33, 14,"D0254672"));
        assertEquals("Invalid Product ID", e.getMessage());
    }
}
