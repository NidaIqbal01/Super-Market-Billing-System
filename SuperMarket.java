package supermarket;

import java.util.ArrayList;
import java.util.Scanner;

public class SuperMarket {

    private final ArrayList<Item> items;
    private ArrayList<Customer> customers;
    private final PaymentMethod paymentMethod;

    public SuperMarket(ArrayList<Item> items, ArrayList<Customer> customers, PaymentMethod paymentMethod) {
        this.items = items;
        this.customers = customers;
        this.paymentMethod = paymentMethod;
    }

    // CRUD operations for Items
    public void addItem(String name, double price, int quantity) {
        Item newItem = new Item(name, price, quantity);
        items.add(newItem);
        System.out.println("Item added: " + name);
    }

    public void viewItems() {
        if (items.isEmpty()) {
            System.out.println("No items in the inventory.");
        } else {
            System.out.println("Items in the inventory:");
            items.forEach(item -> item.displayInfo());
        }
    }

  public void updateItem(String name) {
    for (Item item : items) {
        if (item.getName().equalsIgnoreCase(name)) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\t\tItem found: ");
            item.displayInfo();
            System.out.println("\t\tWhat would you like to update?");
            System.out.println("\t\t1. Quantity");
            System.out.println("\t\t2. Price");
            System.out.println("\t\t3. All Fields");
            System.out.print("\t\tEnter your choice: ");
            int updateChoice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (updateChoice) {
                case 1: // Update Quantity
                    System.out.print("\t\tEnter new quantity: ");
                    int newQuantity = sc.nextInt();
                    item.setQuantity(newQuantity); // Update quantity of the item
                    System.out.println("\t\tItem quantity updated.");
                    break;
                case 2: // Update Price
                    System.out.print("\t\tEnter new price: ");
                    double newPrice = sc.nextDouble();
                    item.setPrice(newPrice); // Update price of the item
                    System.out.println("\t\tItem price updated.");
                    break;
                case 3: // Update All Fields
                    System.out.print("\t\tEnter new name: ");
                    String updatedName = sc.nextLine();
                    System.out.print("\t\tEnter new price: ");
                    double updatedPrice = sc.nextDouble();
                    System.out.print("\t\tEnter new quantity: ");
                    int updatedQuantity = sc.nextInt();
                    
                    // Update name, price, and quantity directly
                    item.setName(updatedName); // Update name using the setter
                    item.setPrice(updatedPrice); // Update price using the setter
                    item.setQuantity(updatedQuantity); // Update quantity using the setter

                    System.out.println("\t\tAll fields updated.");
                    break;
                default:
                    System.out.println("\t\tInvalid choice.");
                    break;
            }
            return;
        }
    }
    System.out.println("\t\tItem not found: " + name);
}

    public void deleteItem(String name) {
        items.removeIf(item -> item.getName().equalsIgnoreCase(name));
        System.out.println("Deleted item: " + name);
    }

    public Item searchItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null; // Item not found
    }

    // CRUD operations for Customer
    public void addCustomer(String customerId, String name, String address, String email) {
        this.customers.add(new Customer(customerId, name, address, email));
        System.out.println("\t\tCustomer added: " + name);
    }

   public void updateCustomer(String customerId) {
    Customer customerToUpdate = Customer.searchCustomer(customers, customerId);
    if (customerToUpdate == null) {
        System.out.println("\t\tCustomer ID not found.");
        return;
    }

    System.out.println("\t\tCustomer found: ");
    customerToUpdate.displayInfo();

    // Prompt for which field to update
    Scanner sc = new Scanner(System.in);
    System.out.println("\t\tWhich field would you like to update?");
    System.out.println("\t\t1. Name");
    System.out.println("\t\t2. Address");
    System.out.println("\t\t3. Email");
    System.out.println("\t\t4. All Fields");
    System.out.print("\t\tEnter your choice: ");
    int updateChoice = sc.nextInt();
    sc.nextLine(); // Consume newline

    switch (updateChoice) {
        case 1: // Update Name
            System.out.print("\t\tEnter new name: ");
            String newName = sc.nextLine();
            customerToUpdate.setName(newName);
            System.out.println("\t\tCustomer name updated.");
            break;
        case 2: // Update Address
            System.out.print("\t\tEnter new address: ");
            String newAddress = sc.nextLine();
            customerToUpdate.setAddress(newAddress);
            System.out.println("\t\tCustomer address updated.");
            break;
        case 3: // Update Email
            System.out.print("\t\tEnter new email: ");
            String newEmail = sc.nextLine();
            customerToUpdate.setEmail(newEmail);
            System.out.println("\t\tCustomer email updated.");
            break;
        case 4: // Update All Fields
            System.out.print("\t\tEnter new name: ");
            String updatedName = sc.nextLine();
            System.out.print("\t\tEnter new address: ");
            String updatedAddress = sc.nextLine();
            System.out.print("\t\tEnter new email: ");
            String updatedEmail = sc.nextLine();
            customerToUpdate.setName(updatedName);
            customerToUpdate.setAddress(updatedAddress);
            customerToUpdate.setEmail(updatedEmail);
            System.out.println("\t\tAll fields updated.");
            break;
        default:
            System.out.println("\t\tInvalid choice.");
            break;
    }
}


    public void viewCustomer(String customerId) {
        Customer customerToView = Customer.searchCustomer(customers, customerId);
        if (customerToView == null) {
            System.out.println("\t\tCustomer ID not found.");
        } else {
            customerToView.displayInfo();
        }
    }

    public void deleteCustomer(String customerId) {
        Customer customerToDelete = Customer.searchCustomer(customers, customerId);
        if (customerToDelete != null) {
            customers.remove(customerToDelete);
            System.out.println("\t\tCustomer deleted.");
        } else {
            System.out.println("\t\tCustomer ID not found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();

        PaymentMethod pm = new CashPayment(); // Default payment method
        SuperMarket supermarket = new SuperMarket(items, customers, pm);

        while (true) {
            // Print the Welcome Screen and Main Menu
            System.out.println("\n\t\t* * * * * * * * * * * * * * * * * * * * * * * * * ");
            System.out.println("\t\t* * * * Welcome to the Supermarket Main Menu * * *");
            System.out.println("\t\t* * * * * * * * * * * * * * * * * * * * * * * * * ");
            System.out.println("\t\t| 1) Customer  |\n\t\t| 2) Inventory |\n\t\t| 3) Billing   |\n\t\t| 4) Exit      |\n\t\t| Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline

            switch (choice) {
                case 1: // Customer Menu
                    boolean customerMenuActive = true;
                    while (customerMenuActive) {
                        System.out.println("\n\t\tCustomer Management:");
                        System.out.println("\t\t1. Add Customer");
                        System.out.println("\t\t2. Update Customer");
                        System.out.println("\t\t3. View Customer");
                        System.out.println("\t\t4. Delete Customer");
                        System.out.println("\t\t5. Search Customer");
                        System.out.println("\t\t6. Back to Main Menu");
                        System.out.print("\t\tEnter your choice: ");
                        int customerChoice = sc.nextInt();
                        sc.nextLine(); // Consume the newline

                        switch (customerChoice) {
                            case 1: // Add Customer
                                String customerId="";
                                while (true) {
                                    
                                    try {
                                        System.out.print("\t\tEnter Customer ID (integer): ");
                                        customerId = sc.nextLine();

                                        // Check if input is empty
                                        if (customerId == null || customerId.isEmpty()) {
                                            throw new IllegalArgumentException("\t\tCustomer ID is required.");
                                        }

                                        // Validate if input is a valid integer
                                        Integer.parseInt(customerId);
                                        break; // Exit loop if valid
                                    } catch (NumberFormatException e) {
                                        System.out.println("\t\tError: Customer ID must be a valid integer.");
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("\t\tError: " + e.getMessage());
                                    } catch (Exception e) {
                                        System.out.println("\t\tAn unexpected error occurred: " + e.getMessage());
                                    }
                                }

                                System.out.println("\t\tCustomer ID accepted: " + customerId);
                        
                        String name = "";
    while (true) {
        try {
            System.out.print("\t\tEnter Customer Name: ");
            name = sc.nextLine();

            // Check if input is empty
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Customer Name is required.");
            }

            // Check if name contains any numbers
            if (name.matches(".*\\d.*")) {
                throw new IllegalArgumentException("Customer Name cannot contain numbers.");
            }

            break; // Exit loop if valid
        } catch (IllegalArgumentException e) {
            System.out.println("\t\tError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\t\tAn unexpected error occurred: " + e.getMessage());
        }
    }

    System.out.println("\t\tCustomer Name accepted: " + name);
                        String address = "";
    while (true) {
        try {
            System.out.print("\t\tEnter Customer Address: ");
            address = sc.nextLine();

            // Check if input is empty
            if (address == null || address.isEmpty()) {
                throw new IllegalArgumentException("Customer Address is required.");
            }

            break; // Exit loop if valid
        } catch (IllegalArgumentException e) {
            System.out.println("\t\tError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\t\tAn unexpected error occurred: " + e.getMessage());
        }
    }

    System.out.println("\t\tCustomer Address accepted: " + address);

                       
                         String email = "";
    while (true) {
        try {
            System.out.print("\t\tEnter Customer Email: ");
            email = sc.nextLine();

            // Check if input is empty
            if (email == null || email.isEmpty()) {
                throw new IllegalArgumentException("Email is required.");
            }

            // Validate email format (basic validation)
            if (!email.contains("@") || !email.contains(".")) {
                throw new IllegalArgumentException("Email must contain '@' and '.'.");
            }

            break; // Exit loop if valid
        } catch (IllegalArgumentException e) {
            System.out.println("\t\tError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\t\tAn unexpected error occurred: " + e.getMessage());
        }
    }

    System.out.println("\t\tCustomer Email accepted: " + email);
supermarket.addCustomer(customerId, name, address, email);
                        break;
                    
            
            case 2: // Update Customer
                                System.out.print("\t\tEnter customer ID to update: ");
                                String updateId = sc.nextLine();
                                supermarket.updateCustomer(updateId);
                                break;
                            case 3: // View Customer
                                System.out.print("\t\tEnter customer ID to view: ");
                                String viewId = sc.nextLine();
                                supermarket.viewCustomer(viewId);
                                break;
                            case 4: // Delete Customer
                                System.out.print("\t\tEnter customer ID to delete: ");
                                String deleteId = sc.nextLine();
                                supermarket.deleteCustomer(deleteId);
                                break;
                            case 5: // Search Customer
                                System.out.print("\t\tEnter customer ID to search: ");
                                String searchId = sc.nextLine();
                                supermarket.viewCustomer(searchId);
                                break;
                            case 6: // Back to Main Menu
                                customerMenuActive = false;  // Exit the Customer Menu loop and go back to the main menu
                                break;
                            default:
                                System.out.println("\t\tInvalid choice.");
                                break;
                        }
                    }
                    break;

        
    

case 2: // Inventory Menu
                    boolean inventoryMenuActive = true;
                    while (inventoryMenuActive) {
                        System.out.println("\n\t\tInventory Management:");
                        System.out.println("\t\t1. Add Item");
                        System.out.println("\t\t2. View Items");
                        System.out.println("\t\t3. Update Item");
                        System.out.println("\t\t4. Delete Item");
                        System.out.println("\t\t5. Search Item");
                        System.out.println("\t\t6. Back to Main Menu");
                        System.out.print("\t\tEnter your choice: ");
                        int inventoryChoice = sc.nextInt();
                        sc.nextLine(); // Consume the newline

                        switch (inventoryChoice) {
                            case 1: // Add Item
                                System.out.print("\t\tEnter item name: ");
                                String itemName = sc.nextLine();
                                System.out.print("\t\tEnter item price: ");
                                double itemPrice = sc.nextDouble();
                                System.out.print("\t\tEnter item quantity: ");
                                int itemQuantity = sc.nextInt();
                                supermarket.addItem(itemName, itemPrice, itemQuantity);
                                break;
                            case 2: // View Items
                                supermarket.viewItems();
                                break;
                            case 3: // Update Item
                                System.out.print("\t\tEnter item name to update: ");
    String itemToUpdate = sc.nextLine();
    supermarket.updateItem(itemToUpdate);  // No need for the quantity here
    break;
                            case 4: // Delete Item
                                System.out.print("\t\tEnter item name to delete: ");
                                String itemToDelete = sc.nextLine();
                                supermarket.deleteItem(itemToDelete);
                                break;
                            case 5: // Search Item
                                System.out.print("\t\tEnter item name to search: ");
                                String searchItemName = sc.nextLine();
                                Item foundItem = supermarket.searchItem(searchItemName);
                                if (foundItem != null) {
                                    foundItem.displayInfo();
                                } else {
                                    System.out.println("\t\tItem not found.");
                                }
                                break;
                            case 6: // Back to Main Menu
                                inventoryMenuActive = false;  // Exit the Inventory Menu loop and go back to the main menu
                                break;
                            default:
                                System.out.println("\t\tInvalid choice.");
                                break;
                        }
                    }
                    break;

           case 3: // Billing Menu
    BillingSystem billingSystem = new BillingSystem();
while (true) {
    System.out.println("\n\t\tBilling System:");
    System.out.println("\t\t1. Add Item to Cart");
    System.out.println("\t\t2. View Cart");
    System.out.println("\t\t3. Generate Bill");
    System.out.println("\t\t4. Back to Main Menu");
    System.out.print("\t\tEnter your choice: ");
    int billingChoice = sc.nextInt();
    sc.nextLine();

    if (billingChoice == 4) break;

    switch (billingChoice) {
        case 1: // Add Item to Cart
            System.out.print("\t\tEnter Item Name: ");
            String cartItemName = sc.nextLine();
            Item cartItem = supermarket.searchItem(cartItemName);
            if (cartItem != null) {
                System.out.print("\t\tEnter Quantity: ");
                int cartQuantity = sc.nextInt();
                billingSystem.addItem(cartItem, cartQuantity);
            } else {
                System.out.println("\t\tItem not found.");
            }
            break;
        case 2: // View Cart
            billingSystem.viewItems();
            break;
        case 3: // Generate Bill
            double totalAmount = billingSystem.generateBill(); // Assume this returns total bill amount

            // Prompt for payment method
            System.out.println("\n\t\tSelect Payment Method:");
            System.out.println("\t\t1. Cash");
            System.out.println("\t\t2. Credit/Debit Card");
            System.out.print("\t\tEnter your choice: ");
            int paymentChoice = sc.nextInt();
            sc.nextLine(); // Consume the newline

            PaymentMethod paymentMethod;
            switch (paymentChoice) {
                case 1:
                    paymentMethod = new CashPayment();
                    break;
                case 2:
                    paymentMethod = new CardPayment();
                    break;
                default:
                    System.out.println("\t\tInvalid choice. Defaulting to Cash Payment.");
                    paymentMethod = new CashPayment();
            }

            // Process payment
            paymentMethod.processPayment(totalAmount);
            break;
        default:
            System.out.println("\t\tInvalid choice.");
    }
}

    break;



                case 4: // Exit
                    System.out.println("\t\tThank you for using the Supermarket Management System!");
                    System.exit(0);

                default:
                    System.out.println("\t\tInvalid choice.");
                    break;
            }
        }
    }
}
