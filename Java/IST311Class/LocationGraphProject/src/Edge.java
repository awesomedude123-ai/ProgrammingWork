public class Edge {
    private double weight;

    private Vertex destinationVertex;

    public Edge(double weight, Vertex destinationVertex) {
        this.weight = weight;
        this.destinationVertex = destinationVertex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Vertex getDestinationVertex() {
        return destinationVertex;
    }

    public void setDestinationVertex(Vertex destinationVertex) {
        this.destinationVertex = destinationVertex;
    }
}
