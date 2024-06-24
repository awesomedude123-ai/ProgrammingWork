public class Ride implements Comparable<Ride>{
    String fromPlace;
    String toPlace;
    double distance;
    double fare;
    String status;
    Driver rideDriver;
    public Ride(String fp, String tp, double dist){
        this.fromPlace = fp;
        this.toPlace = tp;
        this.distance = dist;
        this.fare = dist * 5.0;
        this.status = "requested";
        rideDriver=null;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public int compareTo(Ride newRide){
        if(this.distance < newRide.distance) return -1;
        else if (this.distance > newRide.distance) return 1;
        else return 0;
    }
    public Driver setRideDriver(Driver ridedriver) {
        this.rideDriver = ridedriver;
        setStatus("booked");
        this.rideDriver.updateStatus("not available");
        return ridedriver;
    }
}