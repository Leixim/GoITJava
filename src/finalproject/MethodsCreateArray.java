package finalproject;

import java.util.Arrays;
import java.util.Random;

public class MethodsCreateArray {

    public  static int SIZEOFARRAY = 10000;


    public static int[] createArrayOfRandomInt() {
        int[] arrayOfInt = new int[SIZEOFARRAY];
        Random random = new Random();
        for (int i = 0; i < arrayOfInt.length; i++) {
            arrayOfInt[i] = random.nextInt(99);
        }
        return arrayOfInt;
    }

    public static int[] createArrayOfSortedMinToMaxInt() {
        int[] arrayOfInt = createArrayOfRandomInt();
        Arrays.sort(arrayOfInt);
        return arrayOfInt;
    }

    public static int[] createArrayOfSortedMinToMaxIntPlusX() {
        Random random = new Random();
        int[] arrayOfInt = createArrayOfSortedMinToMaxInt();
        int[] arrayOfIntPlus = Arrays.copyOf(arrayOfInt, arrayOfInt.length + 1);
        arrayOfIntPlus[arrayOfIntPlus.length-1] = random.nextInt(99);
        return arrayOfIntPlus;
    }

    public static int[] createArrayOfSortedMaxToMinInt() {
        int[] arrayOfInt = new int[SIZEOFARRAY];
        Random random = new Random();
        for (int i = 0; i < arrayOfInt.length; i++) {
            arrayOfInt[i] = random.nextInt(99);
        }
        int temp;
        for (int i = 0; i < arrayOfInt.length; i++) {
            for (int j = i + 1; j < arrayOfInt.length; j++) {
                if (arrayOfInt[i] < arrayOfInt[j]) {
                    temp = arrayOfInt[i];
                    arrayOfInt[i] = arrayOfInt[j];
                    arrayOfInt[j] = temp;
                }
            }
        }
        return arrayOfInt;
    }
}
