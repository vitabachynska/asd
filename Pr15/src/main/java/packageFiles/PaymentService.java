package packageFiles;

public interface PaymentService {
    void pay(double amount);
}

class CardPaymentService implements PaymentService {
    @Override
    public void pay(double amount) {
        System.out.println("Оплата карткою: " + amount + " грн");
    }
}

class CashPaymentService implements PaymentService {
    @Override
    public void pay(double amount) {
        System.out.println("Оплата готівкою: " + amount + " грн");
    }
}
