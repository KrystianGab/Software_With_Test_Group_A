package ie.gmit;

public class Products extends Item {
    private String productID;

    public Products(String name, double price, int quantity, String productID) {
        super(name, price, quantity);
        setProductID(productID);
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        if (productID.charAt(0)=='P') {
            this.productID = productID;
        }
        else {
            throw new IllegalArgumentException("Invalid Product ID");
        }
    }

    public String toString() {
        return "Item ID:" + productID + " " + super.toString();
    }
}
