import java.util.Scanner;

public class ClassAssignment2 {
    public static void main(String[] args) {
        Scanner oldScanner = new Scanner(System.in);
        System.out.println("How many numbers do you want to enter?");
        int len = oldScanner.nextInt();
        int[] numbers = new int[len];
        for(int i = 0; i < len; i++){
            System.out.println("Please enter a number");
            numbers[i] = oldScanner.nextInt();
        }//end for loop
        System.out.println(average(numbers));
    }

    public static double average(int[] numbers) {
        int sum = 0;
        for(int x : numbers){
            sum += x;
        }
        return (sum*1.0)/numbers.length;
    }
}
