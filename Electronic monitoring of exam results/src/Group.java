import java.util.HashMap;
import java.util.Map;

public class Group {
    private Map<String, Student> students = new HashMap<>();
    private Map<String, Subject> subjects = new HashMap<>();
    private String name;

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<String, Student> getStudents() {
        return students;
    }

    public Map<String, Subject> getSubjects() {
        return subjects;
    }
}
