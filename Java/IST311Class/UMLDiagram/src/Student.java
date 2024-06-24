import java.util.ArrayList;

public class Student extends Person{

    private static int id = 0;

    private ArrayList<Course> course;

    private ArrayList<Message> message;

    private ArrayList<Grade> grade;

    public Student(String name) {
        super(name);
        this.course = new ArrayList<>();
        this.message = new ArrayList<>();
        this.grade = new ArrayList<>();
        id++;
    }//constructor

    public void submitAssignment(){

    }

    public Grade viewGrade(){
        return null;
    }

    public void leaveCourse(){

    }
}
