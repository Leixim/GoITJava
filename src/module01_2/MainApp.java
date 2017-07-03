package module01_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) throws Exception {
        int arrayInput[] = new int[5];
        int indexofArray = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (indexofArray < 5) {
            try {
                System.out.println("Enter number " + (indexofArray + 1));
                arrayInput[indexofArray] = Integer.parseInt(reader.readLine());
                indexofArray++;
            } catch (NumberFormatException ex) {
                System.err.println("Invalid input");
            }
        }
        System.out.println("Initial array: " + Arrays.toString(arrayInput));
        Arrays.sort(arrayInput);
        System.out.print("Sorted array: " + Arrays.toString(arrayInput));
    }
}
