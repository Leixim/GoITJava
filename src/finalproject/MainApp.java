package finalproject;

import java.io.IOException;
import java.util.ArrayList;

public class MainApp {
    public static void main(String[] args) throws IOException {

        ArrayList<int[]> arrayListCreate = new ArrayList<>();
        arrayListCreate.add(MethodsCreateArray.createArrayOfRandomInt());
        arrayListCreate.add(MethodsCreateArray.createArrayOfSortedMaxToMinInt());
        arrayListCreate.add(MethodsCreateArray.createArrayOfSortedMinToMaxInt());
        arrayListCreate.add(MethodsCreateArray.createArrayOfSortedMinToMaxIntPlusX());

        for (int i = 0; i < 5; i++) {

            for (int[] ints : arrayListCreate) {
                SortingArrays.sort(ints, i);
            }
            System.out.println();
        }



    }

}
