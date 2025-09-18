import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateIPConnections {
    public static void main(String[] args) throws IOException {
        Scanner oldScanner = new Scanner(new File("/Users/awesomedude123/Downloads/packets.csv"));
        String[] arr = null;
        String src = "";
        String dest = "";
        int ports = -1;
        int portd = -1;
        int count = 0;
        String protocol = "";
        String[] info = null;
        List<String> li = new ArrayList<>();
        int index = 0;
        while (oldScanner.hasNextLine()) {
            arr = oldScanner.nextLine().split(",");
            if (ports < 0 && index != 0) {
                src = arr[2].replace("\"", "");
                dest = arr[3].replace("\"", "");
                protocol = arr[4].replace("\"", "");
                info = arr[6].replace("\"", "").split("  >  ");
                ports = Integer.parseInt(info[0]);
                if (info[1].split(" ")[0].contains("[")) {
                    portd = Integer.parseInt(info[1].split(" ")[0].split("\\[")[0]);
                } else {
                    portd = Integer.parseInt(info[1].split(" ")[0]);
                }//end if else
                count++;
            } else {
                if (protocol.equals(arr[4].replace("\"", ""))) {
                    if (src.equals(arr[2].replace("\"", ""))) {
                        if (dest.equals(arr[3].replace("\"", ""))) {
                            if (protocol.equals("TCP") || protocol.equals("UDP")) {//check tcp udp
                                int portc = 0;
                                int portt = 0;
                                String[] line = arr[6].replace("\"", "").split("  >  ");
                                portc = Integer.parseInt(line[0]);
                                if (line[1].split(" ")[0].contains("[")) {
                                    portt = Integer.parseInt(line[1].split(" ")[0].split("\\[")[0]);
                                } else {//line[1] check
                                    portt = Integer.parseInt(line[1].split(" ")[0]);
                                }//end if else

                                if (portc == ports && portd == portt) {
                                    count++;
                                } else {//portc and d dont match
                                    if (protocol.equals("TCP") || protocol.equals("UDP"))
                                        li.add(src + " --> " + dest + " with protocol " + protocol + " on ports " + ports + " --> " + portd + " with count " + count);
                                    else
                                        li.add(src + " --> " + dest + " with protocol " + protocol + " with count " + count);
                                    src = arr[2].replace("\"", "");
                                    dest = arr[3].replace("\"", "");
                                    protocol = arr[4].replace("\"", "");
                                    if (protocol.equals("TCP") || protocol.equals("UDP")) {
                                        info = arr[6].replace("\"", "").split("  >  ");
                                        ports = Integer.parseInt(info[0]);
                                        if (info[1].split(" ")[0].contains("[")) {
                                            portd = Integer.parseInt(info[1].split(" ")[0].split("\\[")[0]);
                                        } else {
                                            portd = Integer.parseInt(info[1].split(" ")[0]);
                                        }//end if else
                                    } else {
                                        info = arr[6].replace("\"", "").split("  >  ");
                                    }
                                    count = 1;
                                }


                            } else {//protocol has no ports
                                count++;
                            }

                        } else {//dest ip

                            if (protocol.equals("TCP") || protocol.equals("UDP"))
                                li.add(src + " --> " + dest + " with protocol " + protocol + " on ports " + ports + " --> " + portd + " with count " + count);
                            else
                                li.add(src + " --> " + dest + " with protocol " + protocol + " with count " + count);
                            src = arr[2].replace("\"", "");
                            dest = arr[3].replace("\"", "");
                            protocol = arr[4].replace("\"", "");
                            if (protocol.equals("TCP") || protocol.equals("UDP")) {
                                info = arr[6].replace("\"", "").split("  >  ");
                                ports = Integer.parseInt(info[0]);
                                if (info[1].split(" ")[0].contains("[")) {
                                    portd = Integer.parseInt(info[1].split(" ")[0].split("\\[")[0]);
                                } else {
                                    portd = Integer.parseInt(info[1].split(" ")[0]);
                                }//end if else
                            } else {
                                info = arr[6].replace("\"", "").split("  >  ");
                            }
                            count = 1;
                        }

                    } else {//src ip

                        if (protocol.equals("TCP") || protocol.equals("UDP"))
                            li.add(src + " --> " + dest + " with protocol " + protocol + " on ports " + ports + " --> " + portd + " with count " + count);
                        else
                            li.add(src + " --> " + dest + " with protocol " + protocol + " with count " + count);
                        src = arr[2].replace("\"", "");
                        dest = arr[3].replace("\"", "");
                        protocol = arr[4].replace("\"", "");
                        if (protocol.equals("TCP") || protocol.equals("UDP")) {
                            info = arr[6].replace("\"", "").split("  >  ");
                            ports = Integer.parseInt(info[0]);
                            if (info[1].split(" ")[0].contains("[")) {
                                portd = Integer.parseInt(info[1].split(" ")[0].split("\\[")[0]);
                            } else {
                                portd = Integer.parseInt(info[1].split(" ")[0]);
                            }//end if else
                        } else {
                            info = arr[6].replace("\"", "").split("  >  ");
                        }
                        count = 1;
                    }

                } else { // protocol
                    if (protocol.equals("TCP") || protocol.equals("UDP"))
                        li.add(src + " --> " + dest + " with protocol " + protocol + " on ports " + ports + " --> " + portd + " with count " + count);
                    else
                        li.add(src + " --> " + dest + " with protocol " + protocol + " with count " + count);
                    src = arr[2].replace("\"", "");
                    dest = arr[3].replace("\"", "");
                    protocol = arr[4].replace("\"", "");
                    if (protocol.equals("TCP") || protocol.equals("UDP")) {
                        info = arr[6].replace("\"", "").split("  >  ");
                        ports = Integer.parseInt(info[0]);
                        if (info[1].split(" ")[0].contains("[")) {
                            portd = Integer.parseInt(info[1].split(" ")[0].split("\\[")[0]);
                        } else {
                            portd = Integer.parseInt(info[1].split(" ")[0]);
                        }//end if else
                    } else {
                        info = arr[6].replace("\"", "").split("  >  ");
                    }
                    count = 1;

                }//end else statement

            }//end if statement
            index++;
            System.out.println(index);
        }//end while loop

        if (protocol.equals("TCP") || protocol.equals("UDP"))
            li.add(src + " --> " + dest + " with protocol " + protocol + " on ports " + ports + " --> " + portd + " with count " + count);
        else
            li.add(src + " --> " + dest + " with protocol " + protocol + " with count " + count);

        String outputFile = "/Users/awesomedude123/Downloads/connectsOutput.txt";
        try (FileWriter fw = new FileWriter(outputFile)) {
            for (String i : li) {
                fw.write(i + "\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }//end main method
}//end public class
