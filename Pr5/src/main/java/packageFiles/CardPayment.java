package packageFiles;

public class CardPayment implements PaymentMethod {
    public String name() {
        return "Credit Card";
    }

    public boolean pay(int amount) {
        System.out.println("Оплата " + amount + " грн за допомогою банківської картки.");
        return true;
    }
}
