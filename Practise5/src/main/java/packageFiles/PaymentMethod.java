package packageFiles;

interface PaymentMethod {
    String name();
    boolean pay(int amount);

    default boolean payWithFee(int amount, int fee){
        return pay(amount-fee);
    }
}
