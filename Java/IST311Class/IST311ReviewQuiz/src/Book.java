public class Book extends Media {

    private String authorName;

    public Book(String title, String subtitle, String authorName, int numberOfCopies, int idNumber){
        super(title, subtitle, numberOfCopies, idNumber);
        this.authorName = authorName;

    }
    @Override
    boolean checkOut(String name) {
        if(this.heldBy.size()==this.numberOfCopies){
            return false;
        }else{
            System.out.println("Checking out "+this.title+", by "+this.authorName);
            this.heldBy.add(name);
            return true;
        }//end if statement
    }//end checkOut method

    @Override
    boolean checkIn(String name) {
        if(!this.heldBy.contains(name)){
            return false;
        }else{
            System.out.println(name + " checking in "+ this.title);
            this.heldBy.remove(name);
            return true;
        }
    }
}
