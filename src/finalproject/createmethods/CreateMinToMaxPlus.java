package finalproject.createmethods;


import finalproject.CreatingArray;

import java.util.Arrays;
import java.util.Random;

public class CreateMinToMaxPlus implements CreatingArray {
    @Override
    public int[] create(int lengthOfArray) {
            Random random = new Random();
            int[] arrayOfInt = new CreateMinToMaxArray().create(lengthOfArray);
            int[] arrayOfIntPlus = Arrays.copyOf(arrayOfInt, arrayOfInt.length + 1);
            arrayOfIntPlus[arrayOfIntPlus.length-1] = random.nextInt(99);
            return arrayOfIntPlus;
    }
}
