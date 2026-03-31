package packageFiles;

public class Sale {
    private String product;
    private int amount;
    private String email;

    public Sale(String product, int amount, String email) {
        this.product = product;
        this.amount = amount;
        this.email = email;
    }

    public String getProduct() {
        return product;
    }

    public String getEmail() {
        return email;
    }

    public int getAmount() {
        return amount;
    }
}
