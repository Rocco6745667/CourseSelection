public class CsStudent extends Student {
    CsStudent(String name, String id) {
        super(name, id);
        this.major = Course.MAJOR_GROUP.CS;
        this.creditRqProgramming = 6;
        this.creditRqMath = 8;
    }
}
