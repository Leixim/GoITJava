package finalproject;

import finalproject.createmethods.CreateMaxToMinArray;
import finalproject.createmethods.CreateMinToMaxArray;
import finalproject.createmethods.CreateMinToMaxPlus;
import finalproject.createmethods.CreateRandomArray;
import finalproject.sortingmethods.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainApp {
    public static void main(String[] args) throws IOException {
        long before, after;
        List<SortingArray> sortingArrays = new ArrayList<>();
        sortingArrays.add( new BubbleSortUp());
        sortingArrays.add( new BubbleSortDown());
        sortingArrays.add( new NativeArraySort());
        sortingArrays.add( new MergeSort());
        sortingArrays.add( new SelectionSort());

        List<CreatingArray> creatingArrays = new ArrayList<>();
        creatingArrays.add(new CreateMinToMaxArray());
        creatingArrays.add(new CreateMaxToMinArray());
        creatingArrays.add(new CreateMinToMaxPlus());
        creatingArrays.add(new CreateRandomArray());

        for (SortingArray sortingArray : sortingArrays) {
            System.out.printf("%20s",sortingArray.getClass().getSimpleName());
            System.out.println();
            for (CreatingArray creatingArray : creatingArrays) {
                System.out.printf("%-20s", creatingArray.getClass().getSimpleName());
                before = System.nanoTime();
                sortingArray.sort(creatingArray.create(10000));
                after = System.nanoTime();
                System.out.printf("%-15d",(after - before)/1000);
                System.out.println();
            }
            System.out.println();
        }

    }

}
