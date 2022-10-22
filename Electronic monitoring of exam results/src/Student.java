import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private Group group;
    private Map<String,Integer> grades = new HashMap<>();

    Student(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }
}
