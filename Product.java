package supermarket;

public abstract class Product {
    private String name;   // Removed final so it can be modified
    private double price;  // Removed final so it can be modified

    // Constructor
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name (added to allow modification)
    public void setName(String name) {
        this.name = name;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Setter for price (added to allow modification)
    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract method for displaying information (to be implemented by subclasses)
    public abstract void displayInfo();
}
