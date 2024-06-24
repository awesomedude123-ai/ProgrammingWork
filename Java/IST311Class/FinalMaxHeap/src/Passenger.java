import java.util.ArrayList;

public class Passenger {
    String pName;
    ArrayList<Ride> rides;
    public Passenger(String pname){
        this.pName = pname;
        this.rides = new ArrayList<>();
    }
    public Ride requestRide(String fromplace, String toplace, double dist){
        Ride newRide = new Ride(fromplace,toplace,dist);
        rides.add(newRide);
        return newRide;
    }

    public boolean endRide(Ride ride){
        if(!rides.contains(ride)){
            return false;
        }else{
            int index = rides.indexOf(ride);
            Driver driver = ride.rideDriver;
            driver.distanceTravelled+=ride.distance;
            driver.trips++;
            rides.remove(index);
            return true;
        }
    }
}