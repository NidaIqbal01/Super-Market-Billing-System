package supermarket;

import java.util.ArrayList;

public class Customer {
    private String customerId;
    private String name;
    private String address;
    private String email;

    // Constructor
    public Customer(String customerId, String name, String address, String email) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public static Customer searchCustomer(ArrayList<Customer> customers, String customerId) {
        for (Customer customer : customers) {
            if (customer.customerId.equals(customerId)) {
                return customer;
            }
        }
        return null; // Return null if customer not found
    }

    // Getter and setter methods for customerId, name, address, email
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Method to display customer info
    public void displayInfo() {
        System.out.println("\t\tCustomer ID: " + customerId);
        System.out.println("\t\tName: " + name);
        System.out.println("\t\tAddress: " + address);
        System.out.println("\t\tEmail: " + email);
    }
}
