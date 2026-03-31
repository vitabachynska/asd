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
        //run2(books);
        //run3();
        run4();
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
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(N)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Топ-" + N + " тегів: " + topTags);
    }
    private static void run3() {
        List<Sale> sales = Arrays.asList(
                new Sale("Product 2", 2000, "user1@gmail.com"),
                new Sale("Product 3", 3000, "user2@gmail.com"),
                new Sale("Product 1", 1000, "user2@gmail.com"),
                new Sale("Product 3", 3000, "user1@gmail.com"),
                new Sale("Product 2", 2000, "user3@gmail.com")
        );

        Map<String, Integer> productRevenue = sales.stream()
                .collect(Collectors.toMap(
                        Sale::getProduct,
                        Sale::getAmount,
                        Integer::sum
                ));

        System.out.println("Виручка за продуктами: " + productRevenue);

        Map<String, Long> transactionsPerCustomer = sales.stream()
                .collect(Collectors.groupingBy(
                        Sale::getEmail,
                        Collectors.counting()
                ));

        System.out.println("Покупок на клієнта: " + transactionsPerCustomer);
    }
    private static void run4(){
        List<Result> results = Arrays.asList(
                new Success("Success 3"),
                new Failure("Failure 2"),
                new Success("Success 1"),
                new Failure("Failure 1"),
                new Success("Success 2")
        );

        Map<Boolean, Long> counts = results.stream()
                .collect(Collectors.partitioningBy(
                        res -> res instanceof Success,
                        Collectors.counting()
                ));

        System.out.println("Кількість успіхів: " + counts.get(true));
        System.out.println("Кількість помилок: " + counts.get(false));

        List<String> allErrors = results.stream()
                .filter(res -> res instanceof Failure)
                .map(res -> ((Failure) res).error())
                .collect(Collectors.toList());

        System.out.println("Всі повідомлення про помилки: " + allErrors);
    }
}
