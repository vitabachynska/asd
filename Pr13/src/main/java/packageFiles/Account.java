package packageFiles;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account {
    private final long id;
    private int balance;
    private final Lock lock = new ReentrantLock();

    public Account(long id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public long getId() { return id; }
    public Lock getLock() { return lock; }
    public int getBalance() { return balance; }
    public void withdraw(int amount) { balance -= amount; }
    public void deposit(int amount) { balance += amount; }
}

class TransferService {
    public static void transfer(Account from, Account to, int amount) {
        Account first = from.getId() < to.getId() ? from : to;
        Account second = from.getId() < to.getId() ? to : from;

        first.getLock().lock();
        try {
            second.getLock().lock();
            try {
                if (from.getBalance() >= amount) {
                    from.withdraw(amount);
                    to.deposit(amount);

                    System.out.printf("[ПОТІК %s] Переказ %d: Acc %d -> Acc %d | Новий баланс відправника: %d%n",
                            Thread.currentThread().getName(),
                            amount,
                            from.getId(),
                            to.getId(),
                            from.getBalance());
                } else {
                    System.out.printf("[ПОТІК %s] Відмова: Недостатньо коштів на Acc %d%n",
                            Thread.currentThread().getName(),
                            from.getId());
                }
            } finally {
                second.getLock().unlock();
            }
        } finally {
            first.getLock().unlock();
        }
    }
}