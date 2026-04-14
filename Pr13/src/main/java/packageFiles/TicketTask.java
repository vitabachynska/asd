package packageFiles;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TicketTask {
    public static final BlockingQueue<SupportTicket> queue = new LinkedBlockingQueue<>(10);

    public static final SupportTicket POISON_PILL = new SupportTicket(-1, "STOP", "STOP");
}