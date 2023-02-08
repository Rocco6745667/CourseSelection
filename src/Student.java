public class Student extends User {
    Student(String name, String id) {
        super(name, id);
    }

    protected Course.MAJOR_GROUP major;
    protected int creditRqMath;
    protected int creditRqProgramming;

    @Override
    public String getInformation() {
        int creditsCE = 0;
        int creditsCS = 0;

        for (Course obj : courses) {
            if(obj.group == Course.MAJOR_GROUP.CE)
                creditsCE += obj.credit;
            if(obj.group == Course.MAJOR_GROUP.CS)
                creditsCS += obj.credit;
        }

        Boolean canGraduate = (this.creditRqMath <= creditsCS) && (this.creditRqProgramming <= creditsCE);
        return String.format("The student’s name is %s with the student ID of %s majoring in %s. %s's course(s): %s.\n %s is %seligible to graduate.",
                this.name, this.id, major.toString(), this.name, Demo.getListOfCourses(this.courses), this.name, canGraduate ? "" : "NOT ");
    }
}
