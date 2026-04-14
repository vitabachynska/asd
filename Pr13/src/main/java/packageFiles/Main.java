package packageFiles;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws InterruptedException {
        //run1();
        //run2();
        //run3();
        run4();
    }
    private static void run1(){
        List<Order> orders = List.of(
                new Order(1, 2000),
                new Order(2, 1250),
                new Order(3, 800),
                new Order(4, 3000)
        );

        Runnable sumTask = () -> {
            long total = orders.stream()
                    .mapToLong(Order::totalCents)
                    .sum();
            System.out.println("Загальна сума замовлень: " + total + " cents");
        };

        Runnable maxTask = () -> {
            int max = orders.stream()
                    .mapToInt(Order::totalCents)
                    .max()
                    .orElse(0);
            System.out.println("Максимальне замовлення: " + max + " cents");
        };
        System.out.println("Початок виконання завдань...");
        TaskRunner.runAndWait(List.of(sumTask, maxTask));
        System.out.println("Всі звіти сформовані.");
    }
    private static void run2() throws InterruptedException {
        int experiments = 500;
        int failures = 0;

        for (int i = 0; i < experiments; i++) {
            Inventory unsafeInv = new UnsafeInventory();
            
            Thread t1 = new Thread(() -> unsafeInv.reserve(60));
            Thread t2 = new Thread(() -> unsafeInv.reserve(60));

            t1.start();
            t2.start();
            t1.join();
            t2.join();

            if (unsafeInv.available() < 0) {
                failures++;
            }
        }

        System.out.println("Результати Unsafe");
        System.out.println("Всього спроб: " + experiments);
        System.out.println("Залишок < 0: " + failures);

        Inventory safeInv = new SynchronizedInventory();
        Thread t3 = new Thread(() -> safeInv.reserve(60));
        Thread t4 = new Thread(() -> safeInv.reserve(60));
        t3.start(); t4.start();
        t3.join(); t4.join();

        System.out.println("\nРезультат SafeInventory");
        System.out.println("Залишок (очікується 40): " + safeInv.available());
    }
    private static void run3() throws InterruptedException{
        Account acc1 = new Account(1, 1000);
        Account acc2 = new Account(2, 1000);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                TransferService.transfer(acc1, acc2, 10);

                //try {
                //    Thread.sleep(1);
                //} catch (InterruptedException e) {
                //    Thread.currentThread().interrupt();
               // }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                TransferService.transfer(acc2, acc1, 10);

                //try {
                //    Thread.sleep(1);
                //} catch (InterruptedException e) {
                //    Thread.currentThread().interrupt();
                //}
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Фінальний баланс Acc1: " + acc1.getBalance());
        System.out.println("Фінальний баланс Acc2: " + acc2.getBalance());

    }
    private static void run4() throws InterruptedException {
        ConcurrentHashMap<String, Integer> stats = new ConcurrentHashMap<>();
        int consumersCount = 2;

        Thread producerThread = new Thread(new TicketProducer(consumersCount));
        Thread consumer1 = new Thread(new TicketConsumer(stats), "Consumer-1");
        Thread consumer2 = new Thread(new TicketConsumer(stats), "Consumer-2");

        producerThread.start();
        consumer1.start();
        consumer2.start();

        producerThread.join();
        consumer1.join();
        consumer2.join();

        System.out.println("Фінальна статистика за темами: " + stats);
    }
}
