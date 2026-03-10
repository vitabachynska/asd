package packageFiles;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentRegistryTest {
    @Test
    void testRemoveByIdRemovesFromMap() {
        StudentRegistry registry = new StudentRegistry();
        Student s1 = new Student("111", "test@mail.com");
        registry.addStudent(s1, "test@mail.com");
        registry.counter();
        registry.removeById("111");

        assertNull(registry.findById("111"), "Студент має зникнути з Map (findById повертає null)");
        registry.counter();
    }

    @Test
    void testRemoveByIdFreesEmail() {
        StudentRegistry registry = new StudentRegistry();
        String email = "test@mail.com";
        Student s1 = new Student("111", email);
        Student s2 = new Student("222", email);
        registry.addStudent(s1, email);
        registry.counter();

        registry.removeById("111");
        registry.counter();

        assertFalse(registry.containsEmail(email), "Email має бути видалений з Set");

        Student s3 = new Student("222", email);
        assertTrue(registry.addStudent(s3, email), "Email має стати доступним для нового студента");
        registry.counter();
    }

    @Test
    void testDuplicateEmailRejected() {
        StudentRegistry registry = new StudentRegistry();
        registry.addStudent(new Student("111", "same@mail.com"), "same@mail.com");

        boolean result = registry.addStudent(new Student("222", "same@mail.com"), "same@mail.com");

        assertFalse(result, "false при спробі додати дублікат email");
    }
}
