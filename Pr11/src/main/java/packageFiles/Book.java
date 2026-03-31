package packageFiles;

import java.util.List;

public class Book {
    private String title;
    private int year;
    private List<String> tags;

    public Book(String title, int year, List<String> tags) {
        this.title = title;
        this.year = year;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", tags=" + tags +
                '}';
    }
}
