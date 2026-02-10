package packageFiles;

public class PayPalPayment implements PaymentMethod {
    @Override
    public String name() {
        return "PayPal";
    }
    @Override
    public boolean pay(int amount) {
        System.out.println("Оплата " + amount + " грн через PayPal.");
        return true;
    }
}
