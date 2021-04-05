package ie.gmit;

public class Products extends Item {
    private String productID;
    private String productShelf;

    public Products(){}

    public Products(String name, double price, int quantity, String productID, String productShelf) {
        super(name, price, quantity);
        setProductID(productID);
        setProductShelf(productShelf);
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

    public String getProductShelf() {
        return productShelf;
    }

    public void setProductShelf(String productShelf) {
        if (productShelf.length()<=3) {
            this.productShelf = productShelf;
        }
        else{
            throw new IllegalArgumentException("Invalid Shelf Number");
        }
    }

    public String toString() {
        return "Item ID:" + productID + " " + super.toString() + " Shelf: "+productShelf;
    }
}
