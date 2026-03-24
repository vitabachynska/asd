package packageFiles;

import java.time.*;
import java.util.List;
import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {
        ZoneId kyiv = ZoneId.of("Europe/Kyiv");
        ZoneId london = ZoneId.of("Europe/London");

        Event e1 = new Event("Event 1", LocalDateTime.of(2026, 3, 24, 10, 0), 90, kyiv, "Development");
        //Event e2 = new Event("Event 2", LocalDateTime.of(2026, 3, 24, 11, 0), 60, kyiv, "Architecture");
        //Event e3 = new Event("Event 3", LocalDateTime.of(2026, 3, 24, 13, 0), 120, london, "Development");
        //Event e4 = new Event("Event 4", LocalDateTime.of(2026, 3, 24, 13, 0), 60, london, "Architecture");

        //List<Event> schedule = List.of(e1, e2, e3, e4);
        List<Event> schedule = List.of(e1);
        //run1(schedule);
        //run2();
        run3(schedule);
        //run4(schedule);
        }

        private static void run1(List<Event> schedule){
            System.out.println("Розклад подій:");
            schedule.forEach(e -> {
                System.out.println(e.label() + " завершується о " + e.end());
            });
        }

    private static void run2() {
        ZoneId kyiv = ZoneId.of("Europe/Kyiv");
        ZoneId london = ZoneId.of("Europe/London");

        Event e1 = new Event("Event 1", LocalDateTime.of(2026, 3, 24, 10, 0), 90, kyiv, "Development");
        Event e2 = new Event("Event 2", LocalDateTime.of(2026, 3, 24, 11, 0), 60, kyiv, "Architecture");
        Event e3 = new Event("Event 4", LocalDateTime.of(2026, 3, 24, 13, 0), 60, london, "Architecture");

        Event e4 = EventLab.create(() ->
                new Event("Event 3", LocalDateTime.of(2026, 3, 24, 13, 0), 120, london, "Development")
        );

        List<Event> schedule = List.of(e1, e2, e3, e4);

        System.out.println("Усі події");
        List<String> allLabels = EventLab.labels(schedule, Event::label);
        System.out.println(allLabels);

        System.out.println("\nФільтрація: Ранкові (до 12:00) ТА трек 'Development'");
        Predicate<Event> morning = e -> e.getStart().getHour() < 12;
        Predicate<Event> devOnly = e -> e.getTrack().equals("Development");
        List<Event> filtered = EventLab.pick(schedule, morning.and(devOnly));

        EventLab.notifyAll(filtered, System.out::println);

        System.out.println("\nФільтрація: Ранкові (до 12:00) АБО трек 'Development'");
        filtered = EventLab.pick(schedule, morning.or(devOnly));

        EventLab.notifyAll(filtered, System.out::println);

        System.out.println("\nПеревірка конфліктів");
        EventLab.findConflicts(schedule);
    }
    private static void run3(List<Event> schedule){
        LambdaRefactorLab.sortAnonymous(schedule);

        LambdaRefactorLab.sortLambda(schedule);

        LambdaRefactorLab.sortMethodRef(schedule);
    }
    private static void run4(List<Event> schedule){
        if (schedule.size() >= 2) {
            Event e1 = schedule.get(0);
            Event e2 = schedule.get(1);

            Instant instant = DateTimeLab.toInstant(e1);
            System.out.println("Event 1 в UTC (Instant): " + instant);

            long diff = DateTimeLab.minutesBetween(e1, e2);
            System.out.println("Різниця між Event 1 та Event 2: " + diff + " хв");

            ZonedDateTime londonTime = DateTimeLab.startInZone(e1, "Europe/London");
            System.out.println("Event 1 за часом у Лондоні: " + londonTime);
        }
    }
}


