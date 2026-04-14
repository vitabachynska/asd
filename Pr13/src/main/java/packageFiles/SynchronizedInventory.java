package packageFiles;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedInventory implements Inventory {
    private int stock = 100;

    @Override
    public synchronized void reserve(int amount) {
        if (stock >= amount) {
            stock -= amount;
        }
    }

    @Override
    public synchronized int available() {
        return stock;
    }


}
