package ie.gmit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InventoryDBTest {
    InventoryDB inventoryDB = new InventoryDB();
    Item item;

    @BeforeEach
    public void init() {
        item = new Item();
    }

    @Test
    public void testFoundProduct() {
        item = inventoryDB.getInventory("vasaline");
        assertEquals("Item ID:P000125 Vasaline for 2.5 Shelf: A01", item.toString());

        item = inventoryDB.getInventory("shampoo");
        assertEquals("Item ID:P456123 Shampoo for 5.0 Shelf: B03", item.toString());

        item = inventoryDB.getInventory("glasses");
        assertEquals("Item ID:P452777 Glasses for 21.99 Shelf: C05", item.toString());
    }

    @Test
    public void testFoundPrescription() {
        item = inventoryDB.getInventory("ventolin");
        assertEquals("Item ID:D464853 Ventolin for 4.75 please pick up at counter", item.toString());

        item = inventoryDB.getInventory("adderall xr");
        assertEquals("Item ID:D114875 Adderall XR for 184.0 please pick up at counter", item.toString());

        item = inventoryDB.getInventory("benzonatate");
        assertEquals("Item ID:D236967 Benzonatate for 21.6 please pick up at counter", item.toString());
    }

    @Test
    public void testInventoryNotFound() {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                inventoryDB.getInventory("apples"));
        assertEquals("Item not in stock", e.getMessage());
    }
}
