public class Grade {
    private Student student;

    private Course course;

    private Assignment assignment;

    private int pointsReceived;

    public Grade(Student student, Course course, Assignment assignment, int pointsReceived){
        this.student = student;
        this.course = course;
        this.assignment = assignment;
        this.pointsReceived = pointsReceived;
    }

    public int calculateGrade(){
        return 0;
    }

}
