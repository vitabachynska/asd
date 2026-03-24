package packageFiles;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.LocalDateTime;

public class Event {
    private String title;
    private LocalDateTime start; // Місцевий час
    private int durationMinutes;
    private ZoneId zone;         // Конкретний ZoneId
    private String track;

    public Event(String title, LocalDateTime start, int durationMinutes, ZoneId zone, String track) {
        this.title = title;
        this.start = start;
        this.durationMinutes = durationMinutes;
        this.zone = zone;
        this.track = track;
    }

    public ZonedDateTime getFullStart() {
        return start.atZone(zone);
    }

    public ZonedDateTime end() {
        return getFullStart().plusMinutes(durationMinutes);
    }

    public String label() {
        return title + " (" + track + ")";
    }

    public LocalDateTime getStart() { return start; }
    public String getTrack() { return track; }
    public String getTitle() { return title; }
    public ZoneId getZone() { return zone; }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %d хв",
                label(), getFullStart().toLocalTime(), zone, durationMinutes);
    }
}
