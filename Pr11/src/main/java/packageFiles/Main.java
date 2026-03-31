package packageFiles;

import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public record Book(String title, String author, int year, List<String> tags) {}
    static List<Book> books = List.of(
            new Book("Clean Code", "Robert Martin", 2008, List.of("clean", "practice", "java")),
            new Book("Effective Java", "Joshua Bloch", 2018, List.of("java", "best", "api")),
            new Book("Modern Java", "Nicolai Parlog", 2020, List.of("java", "streams", "records")),
            new Book("Java Concurrency", "Brian Goetz", 2006, List.of("concurrency", "java"))
    );

    public record Sale(String customerEmail, String product, int cents) {}
    static List<Sale> sales = List.of(
            new Sale("a@ex.com", "Tea", 120),
            new Sale("b@ex.com", "Cake", 200),
            new Sale("a@ex.com", "Tea", 120),
            new Sale("c@ex.com", "Coffee", 150),
            new Sale("b@ex.com", "Cake", 200)
    );
    static void main() {
        //run1(books);
        //run2(books);
        run3(sales);
        //run4();
        //run5(books, sales);
    }

    private static void run1(List<Book> books) {
        List<String> result = books.stream()
                .filter(book -> book.year() > 2015)
                .map(book -> book.title().toUpperCase())
                .sorted()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    private static void run2(List<Book> books) {
        List<String> uniqueTags = books.stream()
                .flatMap(b -> b.tags().stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Унікальні теги: " + uniqueTags);

        int N = 3;
        Map<String, Long> tagFrequency = books.stream()
                .flatMap(b -> b.tags().stream())
                .collect(Collectors.groupingBy(tag -> tag, Collectors.counting()));

        List<String> topTags = tagFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(N)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Топ-" + N + " тегів: " + topTags);
    }
    private static void run3(List<Sale> sales) {
        Map<String, Integer> productRevenue = sales.stream()
                .collect(Collectors.toMap(
                        Sale::product,
                        Sale::cents,
                        Integer::sum
                ));

        System.out.println("Виручка за продуктами: " + productRevenue);

        Map<String, Long> transactionsPerCustomer = sales.stream()
                .collect(Collectors.groupingBy(
                        Sale::customerEmail,
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

    private static void run5(List<Book> books, List<Sale> sales){
        Map<Boolean, List<Book>> recentVsOld = books.stream()
                .collect(Collectors.partitioningBy(b -> b.year() > 2015));
        System.out.println("Нові книги(після 2015): " + recentVsOld.get(true));
        System.out.println("Старі книги(до 2015): " + recentVsOld.get(false));

        TreeMap<String, Integer> sortedRevenue = sales.stream()
                .collect(Collectors.toMap(
                        Sale::product,
                        Sale::cents,
                        Integer::sum,
                        TreeMap::new));

        System.out.println("\nВідсортована виручка: "+sortedRevenue);
    }

}
