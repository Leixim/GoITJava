package finalproject.createmethods;

import finalproject.CreatingArray;

import java.util.Random;

public class CreateRandomArray implements CreatingArray {
    @Override
    public int[] create(int lengthOfArray) {
        int[] arrayOfInt = new int[lengthOfArray];
        Random random = new Random();
        for (int i = 0; i < arrayOfInt.length; i++) {
            arrayOfInt[i] = random.nextInt(99);
        }
        return arrayOfInt;
    }
}
