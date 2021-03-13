package ie.gmit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerTest {

    private Customer c1;

    @BeforeEach
    void init() {
        c1 = new Customer("Emmett Cowan", "1234567u", "97 Rhylin Glebe", "g00354127@gmit.ie", "0892297790");
    }

    @Test
    void testConstructorName(){
        assertEquals(c1.getName() ,"Emmett Cowan");
    }

    @Test
    void testConstructorTitleFail(){
        Exception e = assertThrows(IllegalArgumentException.class, ()-> new Customer("123", "123456b", "97 Rhylin Glebe", "g00354127@gmit.ie", "0892297790"));
        assertEquals("invalid Name" , e.getMessage());
    }

    @Test
    void testConstructorPPS(){
        assertEquals(c1.getPPS() ,"1234567u");
    }

    @Test
    void testConstructorPPSFail(){
        Exception e = assertThrows(IllegalArgumentException.class, ()-> new Customer("Emmett Cowan", "123", "97 Rhylin Glebe", "g00354127@gmit.ie", "0892297790"));
        assertEquals("invalid PPS must be 7 digits followed by a letter", e.getMessage());
    }


}
