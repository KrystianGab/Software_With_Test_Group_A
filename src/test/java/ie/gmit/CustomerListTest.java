package ie.gmit;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerListTest {

    private CustomerList customers;
    private Customer c1;

    @BeforeEach
    void init(){
        customers = new CustomerList();
        c1 = new Customer("Emmett Cowan", "1234567u", "97 Rhylin Glebe", "g00354127@gmit.ie", "0892297790");;
    }

    @Test
    void testSize(){
        customers.addCustomer(c1);
        assertEquals(customers.size() ,  1);
    }

    @Test
    void testAddCustomer(){
        int size = customers.size();
        customers.addCustomer(c1);
        assertEquals(customers.size() ,size + 1);
    }

    @Test
    void testAddCustomerFail(){
        customers.addCustomer(c1);
        Exception e = assertThrows(IllegalArgumentException.class, ()-> customers.addCustomer(c1));
        assertEquals("Customer Already in list", e.getMessage());
    }

    @Test
    void testRemoveCustomer(){
        int size = customers.size();
        customers.removeCustomer(c1);
        assertEquals(customers.size() ,size);
    }

    @Test
    void testRemoveCustomerFail(){
        customers.removeCustomer(c1);
        Exception e = assertThrows(IllegalArgumentException.class, ()-> customers.addCustomer(c1));
        assertEquals("Customer not in List", e.getMessage());
    }
}
