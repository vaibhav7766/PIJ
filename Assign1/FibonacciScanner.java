//Vaibhav Sharma
//AIML-B2
//22070126125

package Assign1;
import java.util.Scanner;

public class FibonacciScanner {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        System.out.println(fibonacci(number));
        scan.close();
    }
    public static int fibonacci(int n){
        if(n <= 1){
            return 1;
        }
        else{
            return fibonacci(n - 1)+fibonacci(n - 2);
        }
    }
}