public class Course {
    public enum MAJOR_GROUP {CS, CE};


    public int credit;
    public String title;
    public MAJOR_GROUP group;


    public Course(MAJOR_GROUP group, String title, int credit){
        this.group = group;
        this.title = title;
        this.credit = credit;
    }

    @Override
    public String toString() {
        return title.toString();
    }
}
