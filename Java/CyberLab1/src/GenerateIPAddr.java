import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateIPAddr {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner oldScanner = new Scanner(new File("/Users/awesomedude123/Downloads/packets.csv"));
        int c = 0;
        String[] arr = null;
        List<String> ipAddr = new ArrayList<>();
        while(oldScanner.hasNextLine()){
            if(c!=0){
                arr=oldScanner.nextLine().split(",");
                arr[2]=arr[2].replace("\"","");
                arr[3]=arr[3].replace("\"","");
                if(!ipAddr.contains(arr[2])){
                    ipAddr.add(arr[2]);
                }//end if statement
                if(!ipAddr.contains(arr[3])){
                    ipAddr.add(arr[3]);
                }//end if statement
            }
            c++;
            System.out.println(c);
        }//end while loop
        String outPutFile = "ipaddr.txt";
        try(FileWriter file = new FileWriter(outPutFile)){
            for(String i:ipAddr){
                file.write(i+" \n");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }//end main method
}//end public class
