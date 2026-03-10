package packageFiles;

import java.util.Objects;

public class Student {
    private final String id;
    private String email;

    public Student(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Student{id='" + id + "', email='" + email+ "'}";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
