import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    ArrayList<Roommate> vertices;

    public Graph() {
        vertices = new ArrayList<>();
    }//end constructor

    public void addVertex(String name){
        Roommate roommate = new Roommate(name);
        this.vertices.add(roommate);
    }

    public void addEdge(String start, String end,double weight){
        Roommate startRoommate = null;
        Roommate endRoommate = null;
        for(Roommate roommate : vertices){
            if(roommate.getName().equals(start)){
                startRoommate = roommate;
            }else{
                if(roommate.getName().equals(end)){
                    endRoommate = roommate;
                }//end if else
            }//end if else
        }//end for loop
        if(startRoommate ==null){
            startRoommate = new Roommate(start);
            this.vertices.add(startRoommate);
        }else if(endRoommate ==null){
            endRoommate = new Roommate(end);
            this.vertices.add(endRoommate);
        }
        OwesEdge owesEdge = new OwesEdge(endRoommate,weight);
        startRoommate.getEdges().add(owesEdge);

    }

    public boolean containsVertex(String name){
        return getIndexOfVertex(name)>=0;
    }

    public int getIndexOfVertex(String name) {
        int index = 0;
        for(Roommate v : vertices){
            if(v.getName().equals(name)){
                return index;
            }else{
                index++;
            }
        }
        return -1;
    }

    public double getDistanceBFS(String start, String end) {
        Queue<Roommate> bfsTraversal = new LinkedList<>();
        ArrayList<Roommate> visitedVertices = new ArrayList<>();
        ArrayList<Double> dist = new ArrayList<>();

        int index = this.getIndexOfVertex(start);
        int endIndex = this.getIndexOfVertex(end);
        bfsTraversal.add(this.vertices.get(index));
        visitedVertices.add(this.vertices.get(index));
        while (!bfsTraversal.isEmpty()) {
            Roommate current = bfsTraversal.remove();
            if (current.getName().equals(end)) {
                break;
            }
            for (OwesEdge edge : current.getEdges()) {
                if (!visitedVertices.contains(edge.getVertex())) {
                    bfsTraversal.add(edge.getVertex());
                    visitedVertices.add(edge.getVertex());
                    dist.add(edge.getWeight());
                }
            }
        }
        if(dist.isEmpty() || !visitedVertices.contains(this.vertices.get(endIndex))){
            return -1;
        }else{
            double weight = 0;
            for(double value : dist){
                weight+=value;
            }
            return weight;
        }
    }

    public boolean isConnectedBFS(String start, String end) {
        Queue<Roommate> bfsTraversal = new LinkedList<>();
        ArrayList<Roommate> visitedVertices = new ArrayList<>();
        ArrayList<Double> dist = new ArrayList<>();

        int index = this.getIndexOfVertex(start);
        int endIndex = this.getIndexOfVertex(end);
        bfsTraversal.add(this.vertices.get(index));
        visitedVertices.add(this.vertices.get(index));
        while (!bfsTraversal.isEmpty()) {
            Roommate current = bfsTraversal.remove();
            if (current.getName().equals(end)) {
                break;
            }
            for (OwesEdge edge : current.getEdges()) {
                if (!visitedVertices.contains(edge.getVertex())) {
                    bfsTraversal.add(edge.getVertex());
                    visitedVertices.add(edge.getVertex());
                    dist.add(edge.getWeight());
                }
            }
        }
        if(dist.isEmpty() || !visitedVertices.contains(this.vertices.get(endIndex))){
            return false;
        }else{
            return true;
        }
    }

    public double makePayment(String owedBy, String owesTo, double amount){
        if(this.isConnectedBFS(owedBy,owesTo)){
            int index = this.getIndexOfVertex(owedBy);
            Roommate current = this.vertices.get(index);
            for(int i =0;i<current.getEdges().size() && amount>0;i++){
                OwesEdge edge = current.getEdges().get(i);
                if(edge.getVertex().getName().equals(owesTo)){
                    double temp = edge.getWeight();
                    if(amount>= edge.getWeight()){
                        current.getEdges().remove(i);
                    }else{
                        edge.setWeight(edge.getWeight()-amount);
                    }
                    amount -= temp;
                    if(i>=0 && !current.getEdges().isEmpty()){
                        owesTo = current.getEdges().get(0).getVertex().getName();
                        i = -1;
                    }//end if statement
                }//end if else statement
            }//end for loop
        }//end if statement
        return amount;
    }//end method

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Roommate roommate : this.vertices){
            if(!roommate.getEdges().isEmpty()){
                for(OwesEdge owesEdge : roommate.getEdges()){
                    String edge1 = "["+ roommate.getName()+", " + owesEdge.getVertex().getName()+", "+ owesEdge.getWeight()+"]";
                    sb.append(edge1).append(", ");
                }
            }
        }
        sb.replace(sb.lastIndexOf(", "),sb.length(),"");
        return sb.toString();
    }
}
