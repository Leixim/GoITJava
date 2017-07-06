package finalproject;

import java.io.IOException;

public class SortingArrays {
    public static void sort(int[] ints, int i) throws IOException {
        long before, after;

        switch (i) {
            case 0: {
                before = System.nanoTime();
                MethodsSortArray.sortSelection(ints.clone());
                after = System.nanoTime();
                System.out.printf("%-9d",(after - before) / 1000);
                break;
            }
            case 1: {
                before = System.nanoTime();
                MethodsSortArray.sortMerge(ints.clone());
                after = System.nanoTime();
                System.out.printf("%-9d",(after - before) / 1000);
                break;
            }
            case 2: {
                before = System.nanoTime();
                MethodsSortArray.bubbleSortUp(ints.clone());
                after = System.nanoTime();
                System.out.printf("%-9d",(after - before) / 1000);
                break;
            }
            case 3: {
                before = System.nanoTime();
                MethodsSortArray.bubbleSortDown(ints.clone());
                after = System.nanoTime();
                System.out.printf("%-9d",(after - before) / 1000);
                break;
            }
            case 4: {
                before = System.nanoTime();
                MethodsSortArray.nativeJavaArraysSort(ints.clone());
                after = System.nanoTime();
                System.out.printf("%-9d",(after - before) / 1000);
                break;
            }
        }
    }
}
