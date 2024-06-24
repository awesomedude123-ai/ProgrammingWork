import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassAssignment10Jan1 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> words = new ArrayList<String>();
        Scanner oldScanner = new Scanner(System.in);
        String word = "";
        System.out.println("Enter a word. Type No if there is no word to enter.");
        word=oldScanner.nextLine();
        while(!word.equals("No")){
            words.add(word);
            System.out.println("Enter a word. Type No if there is no word to enter.");
            word=oldScanner.nextLine();
        }

        PrintWriter writer = new PrintWriter("words.txt");
        for(int i=words.size()-1; i>=0; i--){
            writer.println(words.get(i));
        }
        writer.close();

    }
}
