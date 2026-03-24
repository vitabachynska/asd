package packageFiles;

import java.util.*;
import java.util.function.*;

public class EventLab {
    public static List<Event> pick(List<Event> events, Predicate<Event> condition) {
        List<Event> result = new ArrayList<>();
        for (Event e : events) if (condition.test(e)) result.add(e);
        return result;
    }

    public static List<String> labels(List<Event> events, Function<Event, String> transformer) {
        List<String> result = new ArrayList<>();
        for (Event e : events) result.add(transformer.apply(e));
        return result;
    }

    public static void notifyAll(List<Event> events, Consumer<Event> action) {
        for (Event e : events) action.accept(e);
    }

    public static Event create(Supplier<Event> factory) {
        return factory.get();
    }

    public static void findConflicts(List<Event> events) {
        for (int i = 0; i < events.size(); i++) {
            for (int j = i + 1; j < events.size(); j++) {
                Event e1 = events.get(i);
                Event e2 = events.get(j);

                if (e1.getFullStart().toInstant().isBefore(e2.end().toInstant()) &&
                        e1.end().toInstant().isAfter(e2.getFullStart().toInstant())) {
                    System.out.println("Збіг: " + e1.getTitle() + " та " + e2.getTitle());
                }
            }
        }
    }
}
