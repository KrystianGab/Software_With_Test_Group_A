package ie.gmit;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomerList implements Serializable {

    private ArrayList<Customer> Customers;

    public  CustomerList(){
        Customers = new ArrayList<Customer>();
    }

    public int size(){
        return  Customers.size();
    }

    public void addCustomer(Customer c1){
        for(int i = 0; i < Customers.size(); i++){
            if(Customers.get(i).getName() == c1.getName()){
                throw new IllegalArgumentException("Customer Already in list");
            }
        }
        Customers.add(c1);
    }

    public void removeCustomer(Customer c1){
        boolean exists = false;
        for(int i = 0; i < Customers.size(); i++){
            if(Customers.get(i).getName() == c1.getName()){
                Customers.remove(i);
                exists = true;
            }
        }
        if(!exists){
            throw new IllegalArgumentException("Customer not in List");
        }

    }

    public Customer get(int counter) {
        boolean exists = false;
        for(int i = 0; i < Customers.size(); i++){
            if(counter  <= Customers.size()){
                exists = true;
            }
        }
        if(!exists){
            throw new IllegalArgumentException("Customer Index wrong");
        }
        return Customers.get(counter);
    }

}
