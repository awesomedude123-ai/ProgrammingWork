import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LocationGraph {
    public ArrayList<Vertex> vertices;

    public LocationGraph(){
        this.vertices = new ArrayList<>();
    }

    public boolean addLocation(String location){
        boolean found = false;
        for(Vertex v : this.vertices){
            if(v.equals(location)){
                found = true;
                break;
            }
        }
        if(found){
            return false;
        }else{
            Vertex vertex = new Vertex(location);
            this.vertices.add(vertex);
            return true;
        }
    }//end addLocation Method

    public boolean addDistance(String locationA, String locationB, double weight){
        Vertex vertexA = null;
        Vertex vertexB = null;
        int indexA = 0;
        int indexB = 0;
        int index = 0;
        for(Vertex v : this.vertices){
            if(v.getLocationName().equals(locationA)){
                vertexA=v;
                indexA=index;
            }else if(v.getLocationName().equals(locationB)){
                vertexB=v;
                indexB=index;
            }
            index++;
        }

        if(vertexA==null){
            vertexA = new Vertex(locationA);
            this.vertices.add(vertexA);
            indexA=this.vertices.size()-1;
            if(vertexB==null){
                vertexB = new Vertex(locationB);
                this.vertices.add(vertexB);
                indexB=this.vertices.size()-1;
            }

        }else if(vertexB==null){
            vertexB = new Vertex(locationB);
            this.vertices.add(vertexB);
            indexB = this.vertices.size()-1;
        }
        boolean isEdgeFound = false;
        for(Edge edge : vertexA.getListOfEdges()){
            if(edge.getDestinationVertex().getLocationName().equals(locationB)){
                isEdgeFound=true;
                break;
            }
        }

        if(isEdgeFound){
            return false;
        }

        Edge edgeA = new Edge(weight,vertexB);
        Edge edgeB = new Edge(weight,vertexA);
        vertexA.getListOfEdges().add(edgeA);
        vertexB.getListOfEdges().add(edgeB);
        return true;
    }//end addDistance Method

    private int getVertexIndex(String location){
        int counter = 0;
        for(Vertex v : this.vertices){
            if(v.getLocationName().equals(location)){
                return counter;
            }
            counter++;
        }//end for loop
        return -1;
    }

    public double findDistanceBreadthFirst(String start, String end){
        Queue<Vertex> bfsTraversal = new LinkedList<>();
        ArrayList<Vertex> visitedVertices = new ArrayList<>();
        ArrayList<Double> dist = new ArrayList<>();

        int index = this.getVertexIndex(start);
        int endIndex = this.getVertexIndex(end);
        bfsTraversal.add(this.vertices.get(index));
        visitedVertices.add(this.vertices.get(index));
        while(!bfsTraversal.isEmpty()){
            Vertex current = bfsTraversal.remove();
            if(current.getLocationName().equals(end)){
                break;
            }
            for(Edge edge : current.getListOfEdges()){
                if(!visitedVertices.contains(edge.getDestinationVertex())){
                    bfsTraversal.add(edge.getDestinationVertex());
                    visitedVertices.add(edge.getDestinationVertex());
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
    }//end method

    private double distanceDepthFirstSearch(String locationA, boolean[] vertice, double distance, String locationB) {
        int index = this.getVertexIndex(locationA);
        vertice[index] = true;
        if (locationA.equals(locationB)) {
            return distance;
        }
        for (Edge edges : this.vertices.get(index).getListOfEdges()) {
            if (!vertice[this.getVertexIndex(edges.getDestinationVertex().getLocationName())]) {
                return distanceDepthFirstSearch(edges.getDestinationVertex().getLocationName(), vertice, distance + edges.getWeight(), locationB);
            }
        }
        return -1;
    }

    // Wrapper function for DFS
    public double findDistanceDepthFirst(String locationA, String locationB) {
        Vertex vertexA = null;
        Vertex vertexB = null;
        for(Vertex vertex : this.vertices){
            if(vertex.getLocationName().equals(locationB)){
                vertexB=vertex;
            }else if(vertex.getLocationName().equals(locationA)){
                vertexA=vertex;
            }
        }
        if(vertexA==null || vertexB==null){
            return 0.0;
        }
        boolean[] vertice = new boolean[this.vertices.size()];
        return distanceDepthFirstSearch(locationA, vertice, 0, locationB);
    }


    private boolean isCycle(Vertex vertex, boolean[] verts, Vertex previousVertex) {
        verts[this.vertices.indexOf(vertex)] = true;
        for (Edge edge : vertex.getListOfEdges()) {
            if (!verts[this.vertices.indexOf(edge.getDestinationVertex())]) {
                if (isCycle(edge.getDestinationVertex(), verts, vertex)) {
                    return true;
                }
            } else if(edge.getDestinationVertex() != previousVertex) {
                return true;
            }
        }
        return false;
    }

    public boolean detectCycle() {
        boolean[] verts = new boolean[this.vertices.size()];
        return isCycle(this.vertices.get(0), verts, null);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Vertex vertex : vertices){
            sb.append(vertex.getLocationName()+ " -- ");
            ArrayList<Vertex> adjacentVert = new ArrayList<>();
            ArrayList<Double> adjacentDouble = new ArrayList<>();
            for(Edge edge : vertex.getListOfEdges()){
                adjacentVert.add(edge.getDestinationVertex());
                adjacentDouble.add(edge.getWeight());
            }//end for loop
            for(int i=0;i<vertices.size();i++){
                Vertex currentVertex = vertices.get(i);
                if(!vertex.getLocationName().equals(currentVertex.getLocationName())){
                    if(adjacentVert.contains(currentVertex)){
                        int index = adjacentVert.indexOf(currentVertex);
                        sb.append(adjacentDouble.get(index)+" --> "+currentVertex.getLocationName()+" -- ");
                    }else{
                        sb.append("-1 --> "+currentVertex.getLocationName()+" -- ");
                    }
                }
            }//end for loop
            sb.replace(sb.lastIndexOf(" -- "),sb.length(),"");
            sb.append("\n");
        }//end for loop
        sb.replace(sb.lastIndexOf("\n"),sb.length(),"");
        return sb.toString();
    }//end method

    public double findMinimumPath(String locationA, String locationB){
        double bfs = findDistanceBreadthFirst(locationA,locationB);
        double dfs = this.findDistanceDepthFirst(locationA,locationB);
        return Math.min(bfs, dfs);
    }


}
