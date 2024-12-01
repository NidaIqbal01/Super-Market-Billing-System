package supermarket;

import java.util.ArrayList;
import java.util.Scanner;

public class BillingSystem {
    private ArrayList<Item> cartItems;
    private double totalAmount;
    private final double taxRate = 0.1; // Example tax rate (10%)
    private String paymentMethod; // To store the selected payment method

    // Constructor
    public BillingSystem() {
        this.cartItems = new ArrayList<>();
        this.totalAmount = 0.0;
        this.paymentMethod = ""; // Default payment method
    }

    // Add item to the cart
 public void addItem(Item item, int quantity) {
    // Check if the quantity is available in the inventory
    if (item.getQuantity() < quantity) {
        System.out.println("\t\tNot enough stock available for item: " + item.getName());
    } else {
        // Add item to the cart and update the total amount
        Item cartItem = new Item(item.getName(), item.getPrice(), quantity);
        cartItems.add(cartItem);
        totalAmount += item.getPrice() * quantity;

        // Update inventory: subtract the quantity sold from the inventory
        item.setQuantity(item.getQuantity() - quantity);

        System.out.println("\t\tAdded " + quantity + " x " + item.getName() + " to the cart.");
    }
}

    // View items in the cart
    public void viewItems() {
        if (cartItems.isEmpty()) {
            System.out.println("\t\tThe cart is empty.");
        } else {
            System.out.println("\t\tItems in the cart:");
            cartItems.forEach(item -> item.displayInfo());
        }
    }

    // Update the quantity of an item in the cart
    public void updateItem(String itemName, int newQuantity) {
        for (Item cartItem : cartItems) {
            if (cartItem.getName().equalsIgnoreCase(itemName)) {
                // Update the total amount before changing the quantity
                totalAmount -= cartItem.getPrice() * cartItem.getQuantity();
                cartItem.setQuantity(newQuantity);
                totalAmount += cartItem.getPrice() * newQuantity;
                System.out.println("Updated " + itemName + " to quantity: " + newQuantity);
                return;
            }
        }
        System.out.println("\t\tItem not found in cart: " + itemName);
    }

    // Delete an item from the cart
    public void deleteItem(String itemName) {
        for (Item cartItem : cartItems) {
            if (cartItem.getName().equalsIgnoreCase(itemName)) {
                totalAmount -= cartItem.getPrice() * cartItem.getQuantity();
                cartItems.remove(cartItem);
                System.out.println("\t\tRemoved " + itemName + " from the cart.");
                return;
            }
        }
        System.out.println("\t\tItem not found in cart: " + itemName);
    }

    // Generate the final bill and choose a payment method
    public double generateBill() {
        if (cartItems.isEmpty()) {
            System.out.println("\t\tThe cart is empty. Cannot generate bill.");
            return 0;
        }
        double taxAmount = totalAmount * taxRate;
        double finalAmount = totalAmount + taxAmount;
        

        System.out.println("\n\t\t--- Bill ---");
        cartItems.forEach(item -> item.displayInfo());
        System.out.println("\n\t\tTotal Amount: " + totalAmount);
        System.out.println("\t\tTax: " + taxAmount);
        System.out.println("\t\tFinal Amount: " + finalAmount);

       
        
        // Print the selected payment method with the final bill
        System.out.println("\t\tPayment Method: " + paymentMethod);
        return finalAmount;
    }

    // Choose payment method
    

    // Getters and Setters
    public double getTotalAmount() {
        return totalAmount;
    }
}
