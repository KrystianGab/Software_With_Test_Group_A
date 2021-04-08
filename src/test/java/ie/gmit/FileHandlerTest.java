package ie.gmit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileHandlerTest {

    CustomerList customers;
    CustomerList customersRead = new CustomerList();
    Customer c1;
    Customer c2;
    FileHandler fh = new FileHandler();


    @BeforeEach
    void init(){
        customers = new CustomerList();
        c1 = new Customer("Emmett Cowan", "1234567u", "97 Rhylin Glebe", "g00354127@gmit.ie", "0892297790");
        c2 = new Customer("ron seal", "12345467u", "96 Rhylin Glebe", "g00354457@gmit.ie", "0963496590");
    }

    @Test
    void testFileHandler(){
        customers.addCustomer(c1);
        fh.save(customers);
        customersRead = fh.read();
        for (int i = 0; i < customersRead.size(); i++){
            assertEquals(customers.get(i).toString(), customersRead.get(i).toString());
        }
    }

    @Test
    void testFileHandler2(){
        customers.addCustomer(c1);
        customers.addCustomer(c2);
        fh.save(customers);
        customersRead = fh.read();
        for (int i = 0; i < customersRead.size(); i++){
            assertEquals(customers.get(i).toString(), customersRead.get(i).toString());
        }
    }
}
