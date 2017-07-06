package finalproject.createmethods;


import finalproject.CreatingArray;

import java.util.Arrays;

public class CreateMinToMaxArray implements CreatingArray {
    @Override
    public int[] create(int lengthOfArray) {
        int[] arrayOfInt = new CreateRandomArray().create(lengthOfArray);
        Arrays.sort(arrayOfInt);
        return arrayOfInt;
    }
}
