import java.util.ArrayList;

public class Course {
    private static int courseId = 0;

    private String courseName;

    private Professor professor;

    private ArrayList<Assignment> assignment;

    private ArrayList<Student> student;

    public Course(String courseName, Professor professor){
        this.courseName = courseName;
        this.professor = professor;
        this.assignment = new ArrayList<Assignment>();
        this.student = new ArrayList<Student>();
        courseId++;
    }

    public void removeStudent(){

    }

    public void removeProfessor(){

    }

}
