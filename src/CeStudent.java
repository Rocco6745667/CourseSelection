public class CeStudent extends Student {
    CeStudent(String name, String id) {
        super(name, id);
        this.major = Course.MAJOR_GROUP.CE;
        this.creditRqProgramming = 8;
        this.creditRqMath = 6;
    }
}
