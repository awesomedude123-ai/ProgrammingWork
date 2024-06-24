import java.util.ArrayList;

public class Vertex {
    private String locationName;

    private ArrayList<Edge> listOfEdges;

    public Vertex(String locationName){
        this.locationName = locationName;
        this.listOfEdges = new ArrayList<>();
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public ArrayList<Edge> getListOfEdges() {
        return listOfEdges;
    }

    public void setListOfEdges(ArrayList<Edge> listOfEdges) {
        this.listOfEdges = listOfEdges;
    }
}
