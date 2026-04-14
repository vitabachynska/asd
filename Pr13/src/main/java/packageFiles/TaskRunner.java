package packageFiles;

import java.util.ArrayList;
import java.util.List;

public class TaskRunner {
    public static void runAndWait(List<Runnable> tasks) {
        List<Thread> threads = new ArrayList<>();

        for (Runnable task : tasks) {
            Thread thread = new Thread(task);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Потік був перерваний");
            }
        }
    }
}
