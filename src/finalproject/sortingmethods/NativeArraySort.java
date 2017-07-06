package finalproject.sortingmethods;

import finalproject.SortingArray;

import java.util.Arrays;

public class NativeArraySort implements SortingArray {
    @Override
    public void sort(int[] arrayInt) {
        Arrays.sort(arrayInt);
    }
}
