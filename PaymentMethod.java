
package supermarket;
// PaymentMethod Interface
public interface PaymentMethod {
    void processPayment(double amount); // Method to process the payment
    String getMethodName(); // Method to return the payment method name
}
