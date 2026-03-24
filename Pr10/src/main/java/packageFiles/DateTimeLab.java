package packageFiles;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeLab {

    public static Instant toInstant(Event e) {
        return e.getFullStart().toInstant();
    }

    public static long minutesBetween(Event a, Event b) {
        Duration duration = Duration.between(a.getFullStart(), b.getFullStart());
        return Math.abs(duration.toMinutes());
    }

    public static ZonedDateTime startInZone(Event e, String zoneName) {
        ZoneId newZone = ZoneId.of(zoneName);
        return e.getFullStart().withZoneSameInstant(newZone);
    }
}
