import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {
    @Test
    public void testAddVertex(){
        Graph graph = new Graph();

        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");
        graph.addVertex("e");
        graph.addVertex("f");

        assertEquals(6,graph.vertices.size());
    }

    @Test
    public void testAddEdge() {
        Graph graph = new Graph();

        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");
        graph.addVertex("e");
        graph.addVertex("f");

        graph.addEdge("a","b",10);
        graph.addEdge("a","c",16);
        assertEquals(2, graph.vertices.get(0).getEdges().size());
    }

    @Test
    public void testContains() {
        Graph graph = new Graph();

        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");
        graph.addVertex("e");
        graph.addVertex("f");

        assertTrue(graph.containsVertex("b"));
        assertTrue(graph.containsVertex("e"));
        assertFalse(graph.containsVertex("g"));
    }

    @Test
    public void testGetIndex() {
        Graph graph = new Graph();

        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");
        graph.addVertex("e");
        graph.addVertex("f");

        assertEquals(1,graph.getIndexOfVertex("b"));
        assertEquals(4,graph.getIndexOfVertex("e"));
        assertEquals(-1,graph.getIndexOfVertex("g"));
    }

    @Test
    public void testToString() {
        Graph graph = new Graph();

        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");

        graph.addEdge("a","b",10);
        graph.addEdge("a","c",15);

        String value = "[a, b, 10.0], [a, c, 15.0]";
        assertEquals(value,graph.toString());
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

        graph.addEdge("a","e",1.0);
        graph.addEdge("e","b",2.0);
        graph.addEdge("b","c",3);
        graph.addEdge("c","d",4);

        double weight = graph.getDistanceBFS("a","d");
        assertEquals(10, weight,0.0001);

        double weight1 = graph.getDistanceBFS("a","f");
        assertEquals(-1,weight1,0.0001);

        double weight2 = graph.getDistanceBFS("a","c");
        assertEquals(6,weight2,0.0001);
    }

    @Test
    public void testPayment() {
        Graph graph = new Graph();
        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");
        graph.addVertex("e");
        graph.addVertex("f");

        graph.addEdge("a","e",1);
        graph.addEdge("e","b",2);
        graph.addEdge("e","c",3);
        graph.addEdge("c","d",4);
        graph.addEdge("c","a",6);
        graph.addEdge("c","b",9);

        double amount = graph.makePayment("a","e",1);
        assertEquals(0,graph.vertices.get(0).getEdges().size());

        graph.makePayment("e","b",3);
        assertEquals(2,graph.vertices.get(4).getEdges().get(0).getWeight(),0.0001);

        graph.makePayment("c","d",15);
        assertEquals("[c, b, 4.0], [e, c, 2.0]",graph.toString());

        graph.makePayment("e","c",4.0);
        assertEquals("[c, b, 4.0]",graph.toString());
    }


}
