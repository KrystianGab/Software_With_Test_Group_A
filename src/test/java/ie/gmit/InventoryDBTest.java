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
        item = inventoryDB.getInventory("Vasaline");
        assertEquals("Item ID:P000125 Vasaline for 2.5 Shelf: A01", item.toString());

        item = inventoryDB.getInventory("Shampoo");
        assertEquals("Item ID:P456123 Shampoo for 5.0 Shelf: B03", item.toString());

        item = inventoryDB.getInventory("Glasses");
        assertEquals("Item ID:P452777 Glasses for 21.99 Shelf: C05", item.toString());
    }

    @Test
    public void testFoundPrescription() {
        item = inventoryDB.getInventory("Ventolin");
        assertEquals("Item ID:D464853 Ventolin for 4.75", item.toString());

        item = inventoryDB.getInventory("Adderall XR");
        assertEquals("Item ID:D114875 Adderall XR for 184.0", item.toString());

        item = inventoryDB.getInventory("Benzonatate");
        assertEquals("Item ID:D236967 Benzonatate for 21.6", item.toString());
    }

    @Test
    public void testInventoryNotFound() {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                inventoryDB.getInventory("apples"));
        assertEquals("Item not in stock", e.getMessage());
    }
}
