import java.util.ArrayList;

public class Professor extends Person{

    private static int id=0;

    private ArrayList<Course> course;

    private ArrayList<Message> message;
    public Professor(String name) {
        super(name);
        id++;
        this.course = new ArrayList<>();
        this.message = new ArrayList<>();
    }//end constructor

    public void updateGrades(){

    }

}
