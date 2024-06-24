public class App {
    public static void main(String[] args) {
        Book book1 = new Book("Nobody","The No Where Man","Sri",3, 1);
        Book book2 = new Book("Everybody", "The Every Where Man", "John", 1, 2);


        System.out.println("Should return true: "+book1.checkOut("Mark Twain"));

        System.out.println("Should return true: "+book1.checkOut("Charles Dickens"));

        System.out.println("Should return true: "+book1.checkIn("Mark Twain"));

        System.out.println("Should return false: "+book1.checkIn("Samuel Clemins"));

        System.out.println("Should return true: "+book2.checkOut("Mark Twain"));

        System.out.println("Should return false: "+book2.checkOut("Charles Dickens"));

        System.out.println("Should return true: "+book2.checkIn("Mark Twain"));

        System.out.println("Should return true: "+book2.checkOut("Charles Dickens"));
    }
}