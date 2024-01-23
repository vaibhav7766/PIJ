package Assign2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        double[] even;
        int j = 0;
        int k = 0;
        double[] odd;
        System.out.println("Enter number of elements to enter:");
        int size = sc.nextInt();
        even = new double[size];
        odd = new double[size];
        System.out.println("Enter the elements separated by space:");
        double[] array = UserInput.inputArray(size);
        sc.close();
        for (int i = 0; i < size; i++) {
            if (array[i] % 2 == 0) {
                even[j] = array[i];
                j++;
            } else {
                odd[k] = array[i];
                k++;
            }
        }
        System.out.println("Even elements:");
        System.out.println(Arrays.toString(even));
        System.out.println("Odd elements:");
        System.out.print(Arrays.toString(odd));
    }

    public static void print(double[] array, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }
}