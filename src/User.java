import java.util.ArrayList;

public abstract class User {
    protected String name;
    protected String id;
    protected ArrayList<Course> courses;

    User(String name, String id) {
        this.name = name;
        this.id = id;
        this.courses = new ArrayList<Course>();
    }

    public void addCource(Course group) {
        courses.add(group);
    }

    public abstract String getInformation();
}


