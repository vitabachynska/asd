package packageFiles;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaRefactorLab {

    public static void sortAnonymous(List<Event> events) {
        List<Event> copy = new ArrayList<>(events);
        copy.sort(new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2) {
                return e1.getTitle().compareTo(e2.getTitle());
            }
        });
        System.out.println("\nСортування (Анонімний клас): " + copy);
    }

    public static void sortLambda(List<Event> events) {
        List<Event> copy = new ArrayList<>(events);
        copy.sort((e1, e2) -> e1.getTitle().compareTo(e2.getTitle()));
        System.out.println("\nСортування (Лямбда): " + copy);
    }

    public static void sortMethodRef(List<Event> events) {
        List<Event> copy = new ArrayList<>(events);
        copy.sort(Comparator.comparing(Event::getTitle));
        System.out.println("\nСортування (Method Reference): " + copy);
    }
}