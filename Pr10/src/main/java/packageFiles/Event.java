package packageFiles;

import java.time.ZonedDateTime;
import java.time.LocalDateTime;

public class Event {
    private String title;
    private LocalDateTime start;
    private int durationMinutes;
    private String zone;
    private String track;

    public Event(String title, LocalDateTime start, int durationMinutes, String zone, String track) {
        this.title = title;
        this.start = start;
        this.durationMinutes = durationMinutes;
        this.zone = zone;
        this.track = track;
    }

    public LocalDateTime end() {
        return start.plusMinutes(durationMinutes);
    }
    public String label() {
        return title + " (" + track + ")";
    }

    @Override
    public String toString() {
        return String.format("Подія: %s | Початок: %s | Кінець: %s | Зона: %s",
                label(), start, end(), zone);
    }
}
