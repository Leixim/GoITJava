package finalproject.sortingmethods;


import finalproject.SortingArray;

public class SelectionSort implements SortingArray {
    @Override
    public void sort(int[] arrayInt) {
        int min, temp;
        for (int i = 0; i < arrayInt.length-1; i++){
            min = i;
            for (int scan = i+1; scan < arrayInt.length; scan++){
                if (arrayInt[scan] < arrayInt[min])
                    min = scan;
            }
            temp = arrayInt[min];
            arrayInt[min] = arrayInt[i];
            arrayInt[i] = temp;
        }
    }
}
