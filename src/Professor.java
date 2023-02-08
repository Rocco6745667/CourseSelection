public class Professor extends User {
    Professor(String name, String id) {
        super(name, id);
    }

    @Override
    public String getInformation() {
        return String.format("The professor’s name is %s with the employee ID of %s. The professor teaches: %s.", this.name, this.id, Demo.getListOfCourses(this.courses));
    }
}
