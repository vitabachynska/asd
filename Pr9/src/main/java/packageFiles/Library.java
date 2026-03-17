package packageFiles;

class Library {
    private String name;

    public Library(String name) {
        this.name = name;
    }
    public class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public String bookLabel() {
            return "Книга: " + title + ", автор: " + author + " (Доступно в: " + name + ")";
        }
    }
}
