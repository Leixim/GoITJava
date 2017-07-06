package finalproject.sortingmethods;


import finalproject.SortingArray;

public class BubbleSortUp implements SortingArray {


    @Override
    public void sort(int[] arrayInt) {
        int length = arrayInt.length;
        int temp = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < (length - i); j++) {
                if (arrayInt[j - 1] > arrayInt[j]) {
                    temp = arrayInt[j - 1];
                    arrayInt[j - 1] = arrayInt[j];
                    arrayInt[j] = temp;
                }
            }
        }
    }
}
