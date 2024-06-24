import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MaxHeapTest {
    @Test
    public void testEmptyContstructor(){
        MaxHeap<Ride> test = new MaxHeap<>();
        assertEquals(test.heapSize,0);
    }

    @Test
    public void testAppend(){
        MaxHeap<Ride> test = new MaxHeap<>();
        //Declare a number of passengers. For example:
        Passenger p1 = new Passenger("ABC");
        Passenger p2 = new Passenger("LMN");
        Passenger p3 = new Passenger("PQR");
        //Let the passengers request for rides. For Example:
        Ride p1ride = p1.requestRide("source1", "dest1",10);
        Ride p2ride = p2.requestRide("source2","dest2",25);
        Ride p3ride = p3.requestRide("source3","dest3",15);

        test.insert(p1ride);
        test.insert(p2ride);
        test.insert(p3ride);

        for (Ride r1:test.maxHeap
             ) {
            System.out.println(r1.fromPlace+" "+r1.toPlace+" "+r1.distance);
        }
    }

    @Test
    public void testRequestRide(){
        Passenger p1 = new Passenger("Sri");
        Ride r2 = p1.requestRide("State College","Philly",200);

        assertEquals("State College",r2.fromPlace);
        assertEquals("Philly",r2.toPlace);
        assertEquals(200,r2.distance,0.0001);

        assertEquals("requested",r2.status);
        assertNull(r2.rideDriver);
    }

    @Test
    public void testCompareToDriver(){
        Driver d1 = new Driver(1,100,5);
        Driver d2 = new Driver(2,50,10);
        Driver d3 = new Driver(3,100,2);
        Driver d4 = new Driver(4,100,5);

        assertEquals(1,d1.compareTo(d2));
        assertEquals(-1,d1.compareTo(d3));
        assertEquals(0,d1.compareTo(d4));


    }

    @Test
    public void testSetRideDriver(){
        Driver d1 = new Driver(1,100,2);

        Passenger p1 = new Passenger("Sri");

        Ride r1 = p1.requestRide("State College","Philly",100);

        assertEquals("requested",r1.status);
        assertNull(r1.rideDriver);
        assertEquals("available",d1.status);

        r1.setRideDriver(d1);

        assertEquals(d1,r1.rideDriver);
        assertEquals("booked",r1.status);
        assertEquals("not available",d1.status);

    }

    @Test
    public void testAllocateRide(){
        Driver d1 =  new Driver(1, 100,10);
        Driver d2 = new Driver(2, 2000, 15);
        Driver d3 = new Driver(3, 200, 10);
        Driver d4 = new Driver(4, 750, 25);
        Driver d5 = new Driver(5, 800, 200);

        MaxHeap<Driver> drivers = new MaxHeap<>();
        drivers.insert(d1);
        drivers.insert(d2);
        drivers.insert(d3);
        drivers.insert(d4);
        drivers.insert(d5);

        //Declare a number of passengers. For example:
        Passenger p1 = new Passenger("ABC");
        Passenger p2 = new Passenger("LMN");
        Passenger p3 = new Passenger("PQR");
        //Let the passengers request for rides. For Example:
        Ride p1ride = p1.requestRide("source1", "dest1",10);
        Ride p2ride = p2.requestRide("source2","dest2",25);
        Ride p3ride = p3.requestRide("source3","dest3",15);
        Ride p4ride = p1.requestRide("source4","dest4",30);
        Ride p5ride = p2.requestRide("source5","dest5",2);
        //Implement the allotment of each of the rides to appropriate drivers using the Maxheap(s) where the driver with highest average distance travelled gets
        //allotted to a requested ride with the longest distance.

        MaxHeap<Ride> rides = new MaxHeap<>();
        rides.insert(p1ride);
        rides.insert(p2ride);
        rides.insert(p3ride);
        rides.insert(p4ride);
        rides.insert(p5ride);

        AllotRides.allocateRides(rides,drivers);

        System.out.println();
        System.out.println();

        Driver d6 = new Driver(6,100,10);
        Driver d7 = new Driver(7,1000,9);
        Ride p6ride = p3.requestRide("source6","dest6",100);

        drivers.insert(d6);
        drivers.insert(d7);
        rides.insert(p6ride);

        AllotRides.allocateRides(rides,drivers);

        Ride p7ride = p2.requestRide("source7","dest7",90);
        Ride p8ride = p1.requestRide("source8","dest8",10);
        rides.insert(p7ride);
        rides.insert(p8ride);

        System.out.println();
        System.out.println();
        AllotRides.allocateRides(rides,drivers);

        Driver d8 = new Driver(8,1000,90);
        drivers.insert(d8);
        System.out.println();
        System.out.println();
        AllotRides.allocateRides(rides,drivers);

    }

}
