package finalproject.createmethods;


import finalproject.CreatingArray;

import java.util.Random;

public class CreateMaxToMinArray implements CreatingArray{
    @Override
    public int[] create(int lengthOfArray) {
        int[] arrayOfInt = new int[lengthOfArray];
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
