
package supermarket;
import java.util.Scanner;


// Card Payment Class implementing PaymentMethod interface
public class CardPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\t\tEnter card number: ");
        String cardNumber = sc.nextLine();
        System.out.print("\t\tEnter cardholder's name: ");
        String cardHolderName = sc.nextLine();
        System.out.println("\t\tProcessing payment of " + amount + " through card...");
        System.out.println("\t\tPayment successful. Thank you, " + cardHolderName + "!");
    }

    @Override
    public String getMethodName() {
        return "\t\tCard Payment";
    }
}
