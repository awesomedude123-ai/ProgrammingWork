import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GenerateIPAddrAndPort {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner oldScanner = new Scanner(new File("/Users/awesomedude123/Downloads/packets.csv"));
        int c = 0;
        String[] arr=null;
        String[] check = null;
        HashMap<String,List<Integer>> hm = new HashMap<>();
        String ip = "";
        int port = 0;
        while(oldScanner.hasNextLine()){
            if(c!=0) {
                arr = oldScanner.nextLine().split(",");
                ip = arr[2].replace("\"","");
                arr[4]=arr[4].replace("\"","");
                if (arr[4].equals("TCP") || arr[4].equals("UDP")) {
                    arr[6] = arr[6].replace("\"", "");
                    if (arr[6].contains(">")) {
                        if (hm.containsKey(ip)) {

                            port = Integer.parseInt(arr[6].split("  >  ")[0]);
                            if (!hm.get(ip).contains(port)) {
                                if (port <= 1024)
                                    hm.get(ip).add(port);
                            }

                        } else {
                            List<Integer> li = new ArrayList<>();
                            port = Integer.parseInt(arr[6].split("  >  ")[0]);
                            if (port <= 1024)
                                li.add(port);
                            hm.put(ip, li);
                        }//end if else

                        ip = arr[3].replace("\"","");
                        if (hm.containsKey(ip)) {

                            check = arr[6].split("  >  ")[1].split(" ");
                            if (check[0].contains("[")) {
                                port = Integer.parseInt(check[0].split("\\[")[0]);
                                if (!hm.get(ip).contains(port)) {
                                    if (port <= 1024)
                                        hm.get(ip).add(port);
                                }

                            } else {
                                port = Integer.parseInt(check[0].split("\\[")[0]);
                                if (!hm.get(ip).contains(port))
                                    if (port <= 1024)
                                        hm.get(ip).add(port);
                            }

                        } else {
                            List<Integer> li = new ArrayList<>();

                            check = arr[6].split("  >  ")[1].split(" ");
                            if (check[0].contains("[")) {
                                port = Integer.parseInt(check[0].split("\\[")[0]);
                                if (port <= 1024)
                                    li.add(port);
                                hm.put(ip, li);
                            } else {
                                port = Integer.parseInt(check[0].split("\\[")[0]);
                                if (port <= 1024)
                                    li.add(port);
                                hm.put(ip, li);
                            }

                        }
                    }//c if else
                }
            }

            c++;
            System.out.println(c);
        }//end while statement

        String outputFile = "/Users/awesomedude123/Downloads/outputFile.txt";
        try(FileWriter fileWriter = new FileWriter(outputFile)){
            for(String i:hm.keySet()){
                fileWriter.write(i+":"+hm.get(i).stream().sorted().toList().toString()+"\n\n");
            }
        }catch (Exception e) {
            System.out.println(e);
        }//end try catch
        System.out.println(hm.keySet().size());
    }//end main method
}