import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String name;
    private List<Group> groups = new ArrayList<>();

    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Group> getGroups() {
        return groups;
    }
}
