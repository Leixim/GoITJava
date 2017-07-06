package finalproject.sortingmethods;

import finalproject.SortingArray;

public class BubbleSortDown implements SortingArray {
    @Override
    public void sort(int[] arrayInt) {
        int length = arrayInt.length;
        int temp = 0;
        for (int i = 0; i < length; i++) {
            for (int j = (length - 1); j > 0; j--) {
                if (arrayInt[j] < arrayInt[j - 1]) {
                    temp = arrayInt[j - 1];
                    arrayInt[j - 1] = arrayInt[j];
                    arrayInt[j] = temp;
                }
            }
        }
    }
}
