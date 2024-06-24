public class Driver implements Comparable<Driver>{
    int driverID;
    double distanceTravelled;
    int trips;
    String status;
    public Driver(int driverid){
        this.driverID = driverid;
        this.status = "available";
    }
    public Driver(int driverid, double disttravel, int trips){
        this.driverID = driverid;
        this.distanceTravelled = disttravel;
        this.trips = trips;
        this.status = "available";
    }
    public void addDistanceTravelled(double rideDistance) {
        this.distanceTravelled += rideDistance;
    }
    public void addTrip(){
        this.trips++;
    }
    public void updateStatus(String updStatus){
        this.status = updStatus;
    }
    @Override
    public int compareTo(Driver newDriver){
        double average = distanceTravelled/trips;

        double driverObjectAverage = newDriver.distanceTravelled/newDriver.trips;

        if(average>driverObjectAverage){
            return 1;
        }else if(average==driverObjectAverage){
            return 0;
        }else{
            return -1;
        }
    }
}