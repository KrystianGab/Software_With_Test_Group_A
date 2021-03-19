package ie.gmit;

public class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(){}

    public Item(String name, double price, int quantity) {
        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }

    public Item(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length()>=3) {
            this.name = name;
        }
        else {
            throw new IllegalArgumentException("Invalid Name");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
        else{
            throw new IllegalArgumentException("Invalid Price");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >0) {
            this.quantity = quantity;
        }
        else {
            throw new IllegalArgumentException("Invalid Quantity");
        }
    }


    @Override
    public String toString() {
        return name + " for " + price;
    }
}
