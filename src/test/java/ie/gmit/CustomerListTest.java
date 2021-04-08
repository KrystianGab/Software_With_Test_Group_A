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
    private Customer c2;

    @BeforeEach
    void init(){
        customers = new CustomerList();
        c1 = new Customer("Emmett Cowan", "1234567u", "97 Rhylin Glebe", "g00354127@gmit.ie", "0892297790");
        c2 = new Customer("ron seal", "12345467u", "96 Rhylin Glebe", "g00354457@gmit.ie", "0963496590");
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
    void testAddCustomer2(){
        int size = customers.size();
        customers.addCustomer(c1);
        customers.addCustomer(c2);
        assertEquals(customers.size() ,size + 2);
    }

    @Test
    void testAddCustomerFail(){
        customers.addCustomer(c1);
        Exception e = assertThrows(IllegalArgumentException.class, ()-> customers.addCustomer(c1));
        assertEquals("Customer Already in list", e.getMessage());
    }

    @Test
    void testRemoveCustomer(){
        customers.addCustomer(c1);
        customers.addCustomer(c2);
        int size = customers.size();
        customers.removeCustomer(c2);
        assertEquals(customers.size() ,size - 1);
    }

    @Test
    void testRemoveCustomer2(){
        customers.addCustomer(c1);
        int size = customers.size();
        customers.removeCustomer(c1);
        assertEquals(customers.size() ,size - 1);
    }

    @Test
    void testRemoveCustomerFail(){
        Exception e = assertThrows(IllegalArgumentException.class, ()-> customers.removeCustomer(c1));
        assertEquals("Customer not in List", e.getMessage());
    }

    @Test
    void testGet(){
        customers.addCustomer(c1);
        assertEquals(customers.get(0) , c1 );
    }

    @Test
    void testGetFail(){
        customers.addCustomer(c1);
        Exception e = assertThrows(IllegalArgumentException.class, ()-> customers.get(2));
        assertEquals("Customer Index wrong", e.getMessage());
    }
}
