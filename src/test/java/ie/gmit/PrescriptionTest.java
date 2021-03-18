package ie.gmit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrescriptionTest {
    private Prescription p1, p2;

    @BeforeEach
    void init(){
        p1 = new Prescription("Name", 3.33, 14, "D0254672", true);
        p2 = new Prescription("Name2");
    }

    @Test
    public void testPrescriptionCreateSuccess(){
        assertEquals("Name", p1.getName());
        assertEquals(3.33, p1.getPrice());
        assertEquals(14, p1.getQuantity());
        assertEquals("D0254672", p1.getPrescriptionID());
        assertEquals(true, p1.isPrescription());
    }

    @Test
    public void testPrescriptionCreateNameOnlySuccess() {
        assertEquals("Name2", p2.getName());
    }

    @Test
    public void testPrescriptionCreateNameOnlyFail(){
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                new Products("A"));
        assertEquals("Invalid Name", e.getMessage());
    }

    @Test
    public void testConstructorNameFail(){
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                new Prescription("A", 3.33, 14, "D0254672", true));
        assertEquals("Invalid Name", e.getMessage());
    }

    @Test
    public void testConstructorPriceFail(){
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                new Prescription("Name", -3.33, 14,"D0254672", true));
        assertEquals("Invalid Price", e.getMessage());
    }

    @Test
    public void testConstructorQuantityFail(){
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                new Prescription("Name", 3.33, 0,"D0254672", true));
        assertEquals("Invalid Quantity", e.getMessage());
    }

    @Test
    public void testConstructorPrescriptionIDFail(){
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                new Prescription("Name", 3.33, 14,"PO0254672", true));
        assertEquals("Invalid Prescription ID", e.getMessage());
    }

    @Test
    public void testConstructorPrescriptionFail(){
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                new Prescription("Name", 3.33, 14,"DO0254672", false));
        assertEquals("Invalid Prescription", e.getMessage());
    }
}
