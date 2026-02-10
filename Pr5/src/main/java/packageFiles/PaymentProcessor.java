package packageFiles;

public class PaymentProcessor {
    boolean process(PaymentMethod method, int amount){
        if(!PaymentMethod.isValidAmount(amount))
            return false;
        return method.pay(amount);
    }
}
