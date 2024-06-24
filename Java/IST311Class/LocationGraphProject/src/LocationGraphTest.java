import org.junit.Test;

import static org.junit.Assert.*;

public class LocationGraphTest {

    @Test
    public void testAddLocation(){
        LocationGraph graph = new LocationGraph();
        graph.addLocation("Area 1");
        graph.addLocation("Area 2");
        graph.addLocation("Area 3");

        assertEquals("Area 1",graph.vertices.get(0).getLocationName());
        assertEquals("Area 2",graph.vertices.get(1).getLocationName());
        assertEquals("Area 3",graph.vertices.get(2).getLocationName());
    }

    @Test
    public void testAddDistance(){
        LocationGraph graph = new LocationGraph();
        graph.addLocation("Area 1");
        graph.addLocation("Area 2");
        graph.addLocation("Area 3");

        graph.addDistance("Area 1", "Area 2",10);
        graph.addDistance("Area 2", "Area 3",20);
        graph.addDistance("Area 1", "Area 3",30);

        assertEquals(2,graph.vertices.get(0).getListOfEdges().size());
        assertEquals(2,graph.vertices.get(1).getListOfEdges().size());
        assertEquals(2,graph.vertices.get(2).getListOfEdges().size());

        assertFalse(graph.addDistance("Area 2", "Area 1", 30));

    }

    @Test
    public void testFindDistanceBreadthFirst(){
        LocationGraph graph = new LocationGraph();
        graph.addLocation("Area 1");
        graph.addLocation("Area 2");
        graph.addLocation("Area 3");
        graph.addLocation("Area 4");

        graph.addDistance("Area 1", "Area 2",10);
        graph.addDistance("Area 2", "Area 3",20);
        graph.addDistance("Area 3", "Area 4", 30);

        double distance = graph.findDistanceBreadthFirst("Area 1","Area 4");
        assertEquals(distance,60.0,0.0001);
    }

    @Test
    public void testFindDistanceDepthFirst(){
        LocationGraph graph = new LocationGraph();
        graph.addLocation("Area 1");
        graph.addLocation("Area 2");
        graph.addLocation("Area 3");
        graph.addLocation("Area 4");

        graph.addDistance("Area 1", "Area 2",10);
        graph.addDistance("Area 2", "Area 3",20);
        graph.addDistance("Area 3", "Area 4", 30);

        double distance = graph.findDistanceDepthFirst("Area 1","Area 4");
        assertEquals(distance,60.0,0.0001);
    }

    @Test
    public void testToString(){
        LocationGraph graph = new LocationGraph();
        graph.addLocation("Area 1");
        graph.addLocation("Area 2");
        graph.addLocation("Area 3");
        graph.addLocation("Area 4");

        graph.addDistance("Area 1", "Area 2",10);
        graph.addDistance("Area 2", "Area 3",20);
        graph.addDistance("Area 3", "Area 4", 30);
        graph.addDistance("Area 1","Area 3",40);
        String value = "Area 1 -- 10.0 --> Area 2 -- 40.0 --> Area 3 -- -1 --> Area 4\n" +
                "Area 2 -- 10.0 --> Area 1 -- 20.0 --> Area 3 -- -1 --> Area 4\n" +
                "Area 3 -- 40.0 --> Area 1 -- 20.0 --> Area 2 -- 30.0 --> Area 4\n" +
                "Area 4 -- -1 --> Area 1 -- -1 --> Area 2 -- 30.0 --> Area 3";
        assertEquals(value,graph.toString());
    }

    @Test
    public void testDetectCycle(){
        LocationGraph graph = new LocationGraph();
        graph.addLocation("Area 1");
        graph.addLocation("Area 2");
        graph.addLocation("Area 3");
        graph.addLocation("Area 4");

        graph.addDistance("Area 1", "Area 2",10);
        graph.addDistance("Area 2", "Area 3",20);
        graph.addDistance("Area 3", "Area 4", 30);
        //graph.addDistance("Area 1","Area 3",40);
        assertFalse(graph.detectCycle());
        graph.addDistance("Area 1","Area 3",40);
        assertTrue(graph.detectCycle());
    }

    @Test
    public void testMinimumDistance(){
        LocationGraph graph = new LocationGraph();
        graph.addLocation("Area 1");
        graph.addLocation("Area 2");
        graph.addLocation("Area 3");
        graph.addLocation("Area 4");

        graph.addDistance("Area 1", "Area 2",10);
        graph.addDistance("Area 1", "Area 3",20);
        graph.addDistance("Area 3", "Area 4", 30);
        graph.addDistance("Area 2","Area 4",15);
        double distance = graph.findMinimumPath("Area 1", "Area 4");

        assertEquals(distance,25,0.001);
    }

}
