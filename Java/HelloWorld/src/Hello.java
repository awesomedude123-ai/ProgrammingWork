import java.util.Scanner;

public class Hello {
    public static void main(String[] args){
        System.out.println("Hello, Sri");

        int myFirstNumber=5;
        int mySecondNumber=12;
        int myThirdNumber=6;
        int myTotal=myFirstNumber+mySecondNumber+myThirdNumber;
        int myLastOne=1000-myTotal;
        System.out.println(myFirstNumber);
        System.out.println(myTotal);
        System.out.println(myLastOne);


        Scanner oldScanner=new Scanner(System.in);
        Integer[] array1={1,2,3};
        String[] array2={"Hello","World"};
        printArray(array1);
        printArray(array2);

    }//end main method

    public static <T> void printArray(T[] array){
        System.out.println(array);
    }


}
