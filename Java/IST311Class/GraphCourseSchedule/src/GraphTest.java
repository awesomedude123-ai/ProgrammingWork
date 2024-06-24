import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraphTest {

    @Test
    public void testAddVertex() {
        Graph graph = new Graph();
        graph.addVertex("IST140");
        graph.addVertex("IST242");
        graph.addVertex("IST261");
        graph.addVertex("IST311");
        graph.addVertex("IST411");
        assertEquals(5, graph.vertices.size());

    }

    @Test
    public void testAddEdge(){
        Graph graph = new Graph();

        graph.addVertex("IST140");
        graph.addVertex("IST242");
        graph.addVertex("IST261");
        graph.addVertex("IST311");
        graph.addVertex("IST411");
        graph.addEdge("IST140","IST242");
        graph.addEdge("IST242","IST261");
        graph.addEdge("IST242","IST311");
        graph.addEdge("IST311","IST411");
        System.out.println(graph.toString());
    }

    @Test
    public void testGetVertexIndex() {
        Graph graph = new Graph();

        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");

        assertEquals(0,graph.getIndexOfVertex("a"));
        assertEquals(2,graph.getIndexOfVertex("c"));
        assertEquals(-1,graph.getIndexOfVertex("d"));
    }

    @Test
    public void testBFSTraversal() {
        Graph graph = new Graph();
        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");
        graph.addVertex("e");
        graph.addVertex("f");

        graph.addEdge("a","e");
        graph.addEdge("e","b");
        graph.addEdge("b","c");
        graph.addEdge("c","d");

        double weight = graph.getDistanceBFS("a","d");
        assertEquals(10, weight,0.001);

        double weight1 = graph.getDistanceBFS("a","f");
        assertEquals(-1,weight1,0.001);

        double weight2 = graph.getDistanceBFS("a","c");
        assertEquals(6,weight2,0.0001);
    }

    @Test
    public void testToString() {
        Graph graph = new Graph();
        graph.addVertex("IST140");
        graph.addVertex("IST242");
        graph.addVertex("IST261");
        graph.addVertex("IST311");
        graph.addVertex("IST411");
        graph.addEdge("IST140","IST242");
        graph.addEdge("IST242","IST261");
        graph.addEdge("IST242","IST311");
        graph.addEdge("IST311","IST411");
        String value = "IST140 --> [IST242, IST261, IST311, IST411]" +
                "\nIST242 --> [IST261, IST311, IST411]" +
                "\nIST261 --> []" +
                "\nIST311 --> [IST411]" +
                "\nIST411 --> []";
        assertEquals(value,graph.toString());
    }

    @Test
    public void testFindPrerequisites(){
        Graph graph = new Graph();
        graph.addVertex("IST140");
        graph.addVertex("IST242");
        graph.addVertex("IST261");
        graph.addVertex("IST311");
        graph.addVertex("IST411");
        graph.addEdge("IST140","IST242");
        graph.addEdge("IST242","IST261");
        graph.addEdge("IST242","IST311");
        graph.addEdge("IST311","IST411");

        assertEquals("NULL",graph.findPrerequisites("IST450"));

        String value = "For Course IST411, The Following Prerequisites are needed: IST140, IST242, IST311";
        assertEquals(value,graph.findPrerequisites("IST411"));
    }
}