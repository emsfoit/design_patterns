// Strategy interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete strategies implementing the PaymentStrategy interface
class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " via credit card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " via PayPal.");
    }
}

// Context class
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Choose the payment strategy
        PaymentStrategy creditCardPayment = new CreditCardPayment();
        PaymentStrategy paypalPayment = new PayPalPayment();

        // Set the strategy in the context
        cart.setPaymentStrategy(creditCardPayment);
        cart.checkout(100); // Pays 100 via credit card

        // Changing the payment strategy at runtime
        cart.setPaymentStrategy(paypalPayment);
        cart.checkout(200); // Pays 200 via PayPal
    }
}
