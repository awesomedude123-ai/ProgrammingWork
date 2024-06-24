import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    ArrayList<Course> vertices;

    public Graph() {
        vertices = new ArrayList<>();
    }//end constructor

    public void addVertex(String name){
        Course course = new Course(name);
        this.vertices.add(course);
    }

    public void addEdge(String start, String end){
        Course startCourse = null;
        Course endCourse = null;
        int startIndex = 0;
        int endIndex = 0;
        int counter = 0;
        for(Course course : vertices){
            if(course.getName().equals(start)){
                startCourse = course;
                startIndex=counter;
            }else{
                if(course.getName().equals(end)){
                    endCourse = course;
                    endIndex=counter;
                }//end if else
            }//end if else
            counter++;
        }//end for loop
        if(startCourse ==null){
            startCourse = new Course(start);
            this.vertices.add(startCourse);
        }else if(endCourse ==null){
            endCourse = new Course(end);
            this.vertices.add(endCourse);
        }
        Prerequisites prerequisites = new Prerequisites(endCourse);
        startCourse.getEdges().add(prerequisites);
        for(int i=0;i<this.vertices.size();i++){
            if(i!=startIndex){
                if(i!=endIndex){
                    boolean isThere = hasEdge(this.vertices.get(i).getName(),startCourse.getName());
                    if(isThere){
                        Course preReq = this.vertices.get(i);
                        Prerequisites req = new Prerequisites(endCourse);
                        preReq.getEdges().add(req);
                    }
                }
            }else{
                continue;
            }
        }//end for loop
    }

    private boolean hasEdge(String start, String end){
        Course startCourse = null;
        Course endCourse = null;
        int startIndex = 0;
        int endIndex = 0;
        int counter = 0;
        for(Course course : vertices){
            if(course.getName().equals(start)){
                startCourse = course;
                startIndex=counter;
            }else{
                if(course.getName().equals(end)){
                    endCourse = course;
                    endIndex=counter;
                }//end if else
            }//end if else
            counter++;
        }//end for loop
        boolean found = false;
        for(Prerequisites prerequisites : startCourse.getEdges()){
            if(prerequisites.getVertex().getName().equals(end)){
                found = true;
            }
        }
        return found;
    }

    public boolean containsVertex(String name){
        return getIndexOfVertex(name)>=0;
    }

    public int getIndexOfVertex(String name) {
        int index = 0;
        for(Course v : vertices){
            if(v.getName().equals(name)){
                return index;
            }else{
                index++;
            }
        }
        return -1;
    }

    public double getDistanceBFS(String start, String end){
        Queue<Course> bfsTraversal = new LinkedList<>();
        ArrayList<Course> visitedVertices = new ArrayList<>();
        ArrayList<Double> dist = new ArrayList<>();

        int index = this.getIndexOfVertex(start);
        int endIndex = this.getIndexOfVertex(end);
        bfsTraversal.add(this.vertices.get(index));
        visitedVertices.add(this.vertices.get(index));
        while(!bfsTraversal.isEmpty()){
            Course current = bfsTraversal.remove();
            if(current.getName().equals(end)){
                break;
            }
            for(Prerequisites edge : current.getEdges()){
                if(!visitedVertices.contains(edge.getVertex())){
                    bfsTraversal.add(edge.getVertex());
                    visitedVertices.add(edge.getVertex());
                }
            }
        }

        if(!visitedVertices.contains(this.vertices.get(endIndex))){
            return -1;
        }else{
            double weight = 0;
            for(double value : dist){
                weight+=value;
            }
            return weight;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Course course : this.vertices){
            sb.append(course.getName()).append(" --> [");
            boolean visited = false;
            for(Prerequisites prerequisites : course.getEdges()){
                sb.append(prerequisites.getVertex().getName());
                sb.append(", ");
                visited = true;
            }
            if(visited) {
                sb.replace(sb.lastIndexOf(", "), sb.length(), "");
            }
            sb.append("]");
            sb.append("\n");
        }
        sb.replace(sb.lastIndexOf("\n"),sb.length(),"");
        return sb.toString();
    }

    public String findPrerequisites(String courseName){
        Course course = null;
        StringBuilder sb = new StringBuilder();
        sb.append("For Course " + courseName +", The Following Prerequisites are needed: ");
        int index = getIndexOfVertex(courseName);
        if(index == -1){
            return "NULL";
        }else{
            course = this.vertices.get(index);
        }
        for(Course course1 : this.vertices){
            if(!course1.getName().equals(course.getName())){
                for(Prerequisites prec : course1.getEdges()){
                    if(prec.getVertex().getName().equals(courseName)){
                        sb.append(course1.getName());
                        sb.append(", ");
                        break;
                    }
                }
            }
        }
        sb.replace(sb.lastIndexOf(", "),sb.length(),"");
        return sb.toString();
    }
}
