package supermarket;

public class Item extends Product {
    private int quantity;
    private static int idCounter = 1;
    private int id;

    // Constructor
    public Item(String name, double price, int quantity) {
        super(name, price);
        this.quantity = quantity;
        this.id = idCounter++;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Getter for quantity
    public int getQuantity() {
        return quantity;
    }

    // Setter for name (added here)
    public void setName(String name) {
        super.setName(name);
    }

    // Setter for price
    public void setPrice(double price) {
        super.setPrice(price);
    }

    // Setter for quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Override displayInfo method
    @Override
    public void displayInfo() {
        System.out.println("ITEM ID: " + id + "\nITEM: " + getName() + "\nPRICE: PKR " + getPrice() + "\nQUANTITY: " + quantity);
    }
}
