package packageFiles;

import java.util.concurrent.ConcurrentHashMap;

public class TicketConsumer implements Runnable {
    private final ConcurrentHashMap<String, Integer> stats;

    public TicketConsumer(ConcurrentHashMap<String, Integer> stats) {
        this.stats = stats;
    }

    @Override
    public void run() {
        try {
            while (true) {
                SupportTicket ticket = TicketTask.queue.take();

                if (ticket == TicketTask.POISON_PILL) {
                    System.out.println("[Consumer] " + Thread.currentThread().getName() + " завершив роботу.");
                    break;
                }

                stats.merge(ticket.topic(), 1, Integer::sum);
                System.out.println("[Consumer] " + Thread.currentThread().getName() + " обробив: " + ticket.topic());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
