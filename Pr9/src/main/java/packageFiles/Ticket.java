package packageFiles;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Ticket {
    int priority;
    String createdAt;

    public Ticket(int priority, String createdAt) {
        this.priority = priority;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Квиток(пріоритет=" + priority + ", дата=" + createdAt + ")";
    }
}

class TicketComparators {
    public static final Comparator<Ticket> BY_PRIORITY = (t1, t2) -> Integer.compare(t1.priority, t2.priority);
    public static final Comparator<Ticket> BY_DATE = (t1, t2) -> t1.createdAt.compareTo(t2.createdAt);
    //public static final Comparator<Ticket> BY_COMPARING =();


}

