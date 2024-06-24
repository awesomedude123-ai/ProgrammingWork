public class OwesEdge {
    private double weight;
    private Roommate roommate;

    public OwesEdge(Roommate roommate, double weight) {
        this.roommate = roommate;
        this.weight = weight;
    }//end constructor

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Roommate getVertex() {
        return roommate;
    }

    public void setVertex(Roommate roommate) {
        this.roommate = roommate;
    }
}
