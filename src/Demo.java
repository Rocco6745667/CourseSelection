import java.util.*;
import java.util.ArrayList;

//Name: Rocco Ali
//Email: Roccoa24@my.yorku.ca
//Student ID: 2180088487

public class Demo {
    private static ArrayList<Course> listOfCourses;
    private static Scanner sc;
    private static void createListOfCources() {

        listOfCourses.add(new Course(Course.MAJOR_GROUP.CE, "ITEC1000", 1));
        listOfCourses.add(new Course(Course.MAJOR_GROUP.CE, "ITEC1620", 2));
        listOfCourses.add(new Course(Course.MAJOR_GROUP.CE, "ITEC2610", 3));
        listOfCourses.add(new Course(Course.MAJOR_GROUP.CE, "ITEC3610", 1));
        listOfCourses.add(new Course(Course.MAJOR_GROUP.CE, "ITEC4610", 2));

        listOfCourses.add(new Course(Course.MAJOR_GROUP.CS, "MATH1190", 1));
        listOfCourses.add(new Course(Course.MAJOR_GROUP.CS, "MATH2565", 2));
        listOfCourses.add(new Course(Course.MAJOR_GROUP.CS, "MATH2320", 3));
        listOfCourses.add(new Course(Course.MAJOR_GROUP.CS, "MATH3320", 1));
        listOfCourses.add(new Course(Course.MAJOR_GROUP.CS, "MATH4320", 2));
    }

    public static String getListOfCourses(ArrayList<Course> list) {
        StringBuilder sb = new StringBuilder();
        for (Course obj : list) {
            sb.append(obj.toString());
            sb.append(",");
        }
        if(sb.length()>0) {
            sb.delete(sb.length()-1, sb.length());
            return sb.toString();
        }
        return "-";
    }

    private static Course getCourseByName(String name) {
        for (Course obj : listOfCourses) {
            if(obj.title.toUpperCase().equals(name.toUpperCase()))
                return obj;
        }
        return null;
    }

    private static Student registerStudent() {
        System.out.println("Please enter the name of student:\n");
        String name = sc.nextLine();

        System.out.println("Please enter the student ID of student:\n");
        String id = sc.nextLine();

        System.out.format("%s, please enter the major:\n", name);
        String major = sc.nextLine();

        System.out.format("%s, please enter the list of the courses (use comma to separate):\n", name);
        System.out.format("  Cources available: %s.\n", getListOfCourses(listOfCourses));
        String coursesList = sc.nextLine();
        //String coursesList = "ITEC3610,ITEC4610,ITEC1000,ITEC1620,ITEC2610,ITEC4610,MATH1190,MATH2320,MATH4320,MATH2565";
        //String coursesList = "ITEC1620,ITEC2610,ITEC4610,MATH4320,MATH2565";

        Student student = major.equals("CS") ? new CsStudent(name, id) : new CeStudent(name, id);
        for (String s : coursesList.split(",")) {
            Course obj = getCourseByName(s.trim());
            if(obj != null)
                student.courses.add(obj) ;
        }

        return student;
    }

    private static Professor registorProfessor() {
        System.out.println("Please enter the name of the professor:\n");
        String name = sc.nextLine();

        System.out.println("Please enter the employee ID for the professor:\n");
        String id = sc.nextLine();

        System.out.format("Please enter the list of the courses the professor %s is teaching (use comma to separate):\n", name);
        System.out.format("  Cources available: %s.\n", getListOfCourses(listOfCourses));
        //String coursesList = "ITEC2610,ITEC3610";
        String coursesList = sc.nextLine();

        Professor professor = new Professor(name, id);
        for (String s : coursesList.split(",")) {
            Course obj = getCourseByName(s);
            if(obj != null)
                professor.courses.add(obj) ;
        }

        return professor;
    }

    private static void reportInformation(Student student, Professor professor) {
        System.out.println("");

        System.out.format("%s\n\n", student.getInformation());
        System.out.format("%s\n", professor.getInformation());
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        listOfCourses = new ArrayList<Course>();
        createListOfCources();

        Student student = registerStudent();
        Professor professor = registorProfessor();

        reportInformation(student, professor);


    }
}
