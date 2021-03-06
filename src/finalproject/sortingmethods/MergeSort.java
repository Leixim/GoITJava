package finalproject.sortingmethods;


import finalproject.SortingArray;

import java.util.Arrays;

public class MergeSort implements SortingArray {
    @Override
    public void sort(int[] arrayInt) {
        int length = arrayInt.length;
        int n = 1;
        int shift;
        int two_size;
        int[] arr2;
        while (n < length) {
            shift = 0;
            while (shift < length) {
                if (shift + n >= length) break;
                two_size = (shift + n * 2 > length) ? (length - (shift + n)) : n;
                arr2 = merge(Arrays.copyOfRange(arrayInt, shift, shift + n),
                        Arrays.copyOfRange(arrayInt, shift + n, shift + n + two_size));
                for (int i = 0; i < n + two_size; ++i)
                    arrayInt[shift + i] = arr2[i];
                shift += n * 2;
            }
            n *= 2;
        }
    }

    private static int[] merge(int[] arr_1, int[] arr_2) {
        int len_1 = arr_1.length, len_2 = arr_2.length;
        int a = 0, b = 0, len = len_1 + len_2;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (b < len_2 && a < len_1) {
                if (arr_1[a] > arr_2[b]) result[i] = arr_2[b++];
                else result[i] = arr_1[a++];
            } else if (b < len_2) {
                result[i] = arr_2[b++];
            } else {
                result[i] = arr_1[a++];
            }
        }
        return result;
    }
}



