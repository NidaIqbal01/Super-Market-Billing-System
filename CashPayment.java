
package supermarket;
import java.util.Scanner;


// Cash Payment Class implementing PaymentMethod interface
public class CashPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\t\tEnter cash amount given by customer: ");
        double cashGiven = sc.nextDouble();
        if (cashGiven >= amount) {
            double change = cashGiven - amount;
            System.out.println("\t\tPayment successful. Change to return: " + change);
        } else {
            System.out.println("\t\tInsufficient cash provided. Payment failed.");
        }
    }

    @Override
    public String getMethodName() {
        return "\t\tCash Payment";
    }
}
