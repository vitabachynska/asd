package packageFiles;

public record Order(long id, String userEmail, long totalCents) {
    public Order {
        if (id <= 0) {
            throw new IllegalArgumentException("ID має бути більшим за 0");
        }
        if (userEmail == null || !userEmail.contains("@")) {
            throw new IllegalArgumentException("email має містити @");
        }
        if (totalCents < 0) {
            throw new IllegalArgumentException("Кількість центів не може бути від'ємною");
        }
    }
}
