package packageFiles;

public class PaymentProcessor {
    boolean process(PaymentMethod method, int amount){
        return method.pay(amount);
    }
}
