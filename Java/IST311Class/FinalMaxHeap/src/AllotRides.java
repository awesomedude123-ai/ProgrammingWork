public class AllotRides {
    public static void main(String[] args) {
        //Declare a number of drivers with different attribute values. For example:
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

        allocateRides(rides,drivers);


    }

    //Check MaxHeapTest for full performance check
    public static void allocateRides(MaxHeap<Ride> rides, MaxHeap<Driver> drivers) {
        for (int i = 0; i < drivers.heapSize; i++) {
            Driver driver = drivers.maxHeap.get(i);
            if (rides.heapSize == 0) {
                System.out.println("No More Requested Rides");
                break;
            } else if (driver.status.equals("available")) {
                Ride ride = rides.extract();
                if (ride.status.equals("requested")) {
                    ride.setRideDriver(driver);
                    System.out.println("DriverID: "+ driver.driverID+" From: " + ride.fromPlace + " To: " + ride.toPlace + " Distance: " + ride.distance);
                } else {
                    i--;
                }
            }
        }
        if(rides.heapSize>0){
            System.out.println("No More Available Drivers");
        }
    }
}
