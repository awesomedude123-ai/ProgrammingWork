import java.util.ArrayList;

abstract class Media {
    String title;
    String subtitle;
    int numberOfCopies;

    int idNumber;

    ArrayList<String> heldBy;

    public Media(String title, String subtitle, int numberOfCopies, int idNumber) {
        this.title = title;
        this.subtitle = subtitle;
        this.numberOfCopies = numberOfCopies;
        this.idNumber = idNumber;
        this.heldBy = new ArrayList<String>();
    }
    abstract boolean checkOut(String name);

    abstract boolean checkIn(String name);
}
