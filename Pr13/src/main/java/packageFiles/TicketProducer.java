package packageFiles;

public class TicketProducer implements Runnable {
    private final int consumersCount;

    public TicketProducer(int consumersCount) {
        this.consumersCount = consumersCount;
    }

    @Override
    public void run() {
        try {
            TicketTask.queue.put(new SupportTicket(1, "Customer1", "Topic1"));
            TicketTask.queue.put(new SupportTicket(2, "Customer2", "Topic2"));
            TicketTask.queue.put(new SupportTicket(3, "Customer3", "Topic1"));

            for (int i = 0; i < consumersCount; i++) {
                TicketTask.queue.put(TicketTask.POISON_PILL);
            }
            System.out.println("[Producer] Всі дані та сигнали зупинки надіслано.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
