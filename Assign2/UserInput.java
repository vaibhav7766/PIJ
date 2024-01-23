package Assign2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {
    public static double[] inputArray(int size) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String array = br.readLine();
        double[] arrayInput = new double[size];
        String[] input = array.trim().split("\\s+");

        for (int i = 0; i < size; i++) {
            arrayInput[i] = Double.parseDouble(input[i]);
        }
        return arrayInput;
    }
}