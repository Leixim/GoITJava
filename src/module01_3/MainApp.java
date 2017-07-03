package module01_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MainApp {

    //Method of inputing and checking the entered value
    private static int isInputInt() throws Exception {
        int result;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                result = Integer.parseInt(reader.readLine());
                break;
            } catch (NumberFormatException ex) {
                System.err.println("Invalid input. Enter the number");
            }
        }
        return result;
    }



    public static void main(String[] args) throws Exception {
        System.out.println("Enter length of array");
        int lengthofArray = isInputInt();
        if (lengthofArray > 0) {
            int arrayInput[] = new int[lengthofArray];
            int indexofArray = 0;
            while (indexofArray < arrayInput.length) {
                System.out.println("Enter " + (indexofArray + 1) + " element of the array");
                arrayInput[indexofArray] = isInputInt();
                indexofArray++;
            }
            System.out.println();
            System.out.println("Initial array: " + Arrays.toString(arrayInput));
            System.out.println();
            System.out.println("Select actions on the array");
            System.out.println("*********************************************");
            System.out.println("1 - Search for a number by value in an array");
            System.out.println("2 - Sort the entered array");
            System.out.println("3 - Exit the program");
            System.out.println("*********************************************");
            int selection = isInputInt();
            switch (selection) {
                case 1:
                    System.out.println("Enter the required number");
                    int requiredNumber = isInputInt();
                    int countofRequiredNumber = 0;
                    for (int i = 0; i < arrayInput.length; i++) {
                        if (requiredNumber == arrayInput[i]) {
                            countofRequiredNumber++;
                            System.out.println("find in position " + i);
                        }
                    }
                    if (countofRequiredNumber > 0) {
                        System.out.println("The entered number occurs " + countofRequiredNumber + " time(s)");
                    } else {
                        System.out.println("The entered number is absent in the array");
                    }
                    break;
                case 2:
                    Arrays.sort(arrayInput);
                    System.out.print("Sorted array: " + Arrays.toString(arrayInput));
                    break;

                case 3:
                    break;

                default:
                    System.err.println("Wrong selection");
                    break;
            }
        } else {
            System.err.println("Invalid length of array");
        }
    }
}
