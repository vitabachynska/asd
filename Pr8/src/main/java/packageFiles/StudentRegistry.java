package packageFiles;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class StudentRegistry {
    private final List<Student> students = new ArrayList<>();
    private final Set<String> emails = new HashSet<>();
    private final Map<String, Student> byId = new HashMap<>();
    private final Map<String, String> emailById = new HashMap<>();

    public boolean addStudent(Student student, String email) {
        if (byId.containsKey(student.getId()) || !emails.add(email))
            return false;
        students.add(student);
        byId.put(student.getId(), student);
        emailById.put(student.getId(), email);
        return true;
    }

    public Student findById(String id) {
        return byId.get(id);
    }

    public boolean containsEmail(String email) {
        return emails.contains(email);
    }

    public void removeById(String id) {
        Student student = byId.remove(id);
        String email = emailById.remove(id);

        if (student != null) {
            students.remove(student);
        }
        if (email != null) {
            emails.remove(email);
        }
    }
    public void counter(){
        System.out.println("Students: "+ students.size() +" , id: " +byId.size() +" , emails: " + emails.size());
    }
}
