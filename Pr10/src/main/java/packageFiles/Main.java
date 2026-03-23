package packageFiles;

import java.time.LocalDateTime;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {
        Event event1 = new Event("Java Basics", LocalDateTime.of(2026, 3, 24, 10, 0), 90, "Room 1", "Development");
        Event event2 = new Event("Functional Interfaces", LocalDateTime.of(2026, 3, 24, 12, 0), 60, "Room 2", "Architecture");
        Event event3 = new Event("Stream API Deep Dive", LocalDateTime.of(2026, 3, 24, 14, 0), 120, "Room 1", "Development");
        Event event4 = new Event("Networking Lunch", LocalDateTime.of(2026, 3, 24, 13, 0), 45, "Hall", "Social");

        List<Event> schedule = List.of(event1, event2, event3, event4);

        System.out.println("Розклад подій:");
        schedule.forEach(e -> {
            System.out.println(e.label() + " завершується о " + e.end());
        });
        }
    }

