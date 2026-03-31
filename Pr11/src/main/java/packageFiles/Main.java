package packageFiles;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        List<Book> books = Arrays.asList(
                new Book("Book 3", 2017, Arrays.asList("tag 2", "tag 3")),
                new Book("Book 1", 2007, Arrays.asList("tag 5", "tag 7")),
                new Book("Book 6", 2005, Arrays.asList("tag 6", "tag 3")),
                new Book("Book 5", 2025, Arrays.asList("tag 8", "tag 3", "tag 4")),
                new Book("Book 2", 2019, Arrays.asList("tag 2", "tag 3", "tag 1")),
                new Book("Book 4", 2022, Arrays.asList("tag 1", "tag 3"))
        );
        //run1(books);
        run2(books);
    }

    private static void run1(List<Book> books) {
        List<String> result = books.stream()
                .filter(book -> book.getYear() > 2015)
                .map(book -> book.getTitle().toUpperCase())
                .sorted()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    private static void run2(List<Book> books) {
        List<String> uniqueTags = books.stream()
                .flatMap(b -> b.getTags().stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Унікальні теги: " + uniqueTags);

        int N = 3;
        Map<String, Long> tagFrequency = books.stream()
                .flatMap(b -> b.getTags().stream())
                .collect(Collectors.groupingBy(tag -> tag, Collectors.counting()));

        List<String> topTags = tagFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()) // Спадання частоти
                        .thenComparing(Map.Entry.comparingByKey())) // При рівності — за назвою (A-Z)
                .limit(N)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Топ-" + N + " тегів: " + topTags);
    }
}
