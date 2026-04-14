package packageFiles;

public class UnsafeInventory implements Inventory {
    private int stock = 100;

    public void reserve(int amount) {
        if (stock >= amount) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
            stock -= amount;
        }
    }

    public int available() {
        return stock;
    }
}
