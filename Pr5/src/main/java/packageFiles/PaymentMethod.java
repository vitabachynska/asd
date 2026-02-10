package packageFiles;

interface PaymentMethod {
    String name();
    boolean pay(int amount);

    static boolean isValidAmount(int amount){
        return amount>0;
    }
    default boolean payWithFee(int amount, int fee){
        return pay(amount+fee);
    }
}
