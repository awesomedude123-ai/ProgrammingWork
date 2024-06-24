import java.util.ArrayList;

public class Course {
    private ArrayList<Prerequisites> prerequisites;
    private String name;

    public Course(String name){
        this.name = name;
        prerequisites = new ArrayList<>();
    }//end constructor

    public ArrayList<Prerequisites> getEdges() {
        return prerequisites;
    }

    public void setEdges(ArrayList<Prerequisites> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
