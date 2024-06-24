import java.util.ArrayList;

public class Roommate {
    private ArrayList<OwesEdge> owesEdges;
    private String name;

    public Roommate(String name){
        this.name = name;
        owesEdges = new ArrayList<>();
    }//end constructor

    public ArrayList<OwesEdge> getEdges() {
        return owesEdges;
    }

    public void setEdges(ArrayList<OwesEdge> owesEdges) {
        this.owesEdges = owesEdges;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
