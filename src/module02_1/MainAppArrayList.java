package module02_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MainAppArrayList {


    private static int isInputInt() throws Exception {
        int result;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                result = Integer.parseInt(reader.readLine());
                break;
            } catch (NumberFormatException ex) {
                System.err.println("Invalid input. Enter the number");
            }
        }
        return result;
    }


    public static ArrayList<Integer> addValueInArrayList(ArrayList<Integer> arrayList) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter integer to add in collection");
        int inputInt = isInputInt();
        System.out.println("Enter index to add in collection");
        int indexAdd = isInputInt();
        if ((indexAdd >=0) && (indexAdd < arrayList.size()-1) ) {
            ListIterator<Integer> listiterator = arrayList.listIterator();
            while (listiterator.hasNext()) {
                if (listiterator.nextIndex() == indexAdd) {
                    listiterator.add(inputInt);
                } else {
                    listiterator.set(listiterator.next() + inputInt);
                }
            }
        }
        else System.err.println("Invalid index");
        System.out.println(arrayList);
        return arrayList;
    }


    public static ArrayList<Integer> removeValueFromArrayList(ArrayList<Integer> arrayIntList) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ListIterator<Integer> listiterator = arrayIntList.listIterator();
        System.out.println("[1] - remove element by index");
        System.out.println("[2] - remove element by value");
        int menuRemoveSelection = isInputInt();
        switch (menuRemoveSelection) {
            case 1:
                System.out.println("Enter index to remove in collection");
                int indexRemove = isInputInt();
                if ((indexRemove >=0) && (indexRemove < arrayIntList.size()-1) ) {
                    int valueIndexRemove = arrayIntList.get(indexRemove);
                    while (listiterator.hasNext()) {
                        if (listiterator.nextIndex() == indexRemove) {
                            listiterator.set(listiterator.next() - valueIndexRemove);
                            listiterator.remove();
                        }
                        listiterator.set(listiterator.next() - valueIndexRemove);
                    }
                }
                else System.err.println("Invalid index");
                System.out.println(arrayIntList);
                return arrayIntList;
            case 2:
                System.out.println("Enter value to remove in collection");
                int valueRemove = isInputInt();
                if (arrayIntList.contains(valueRemove)) {
                    while (listiterator.hasNext()) {
                        if (listiterator.next() == valueRemove) {
                            listiterator.remove();
                        }
                    }
                    while (listiterator.hasNext()) {
                        listiterator.set(listiterator.next() - valueRemove);
                    }
                        System.out.println(arrayIntList);
                        return arrayIntList;
                    }
                else {
                System.out.println("Entered value is missing in collection ");
                }
            default:
                System.err.println("Invalid menu selection");
                return arrayIntList;
        }


    }

    public static ArrayList<Integer> createOfArrayList() throws Exception {
        Random generator = new Random();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size of collection ");
        int sizeOfCollection = isInputInt();
        if (sizeOfCollection > 0) {
            ArrayList<Integer> arrayIntList = new ArrayList();
            for (int i = 0; i < sizeOfCollection; i++) {
                arrayIntList.add(generator.nextInt(9));
            }
            System.out.println(arrayIntList);
            return arrayIntList;
        } else {
            return new ArrayList();
        }
    }

    public static int maxValueOfArraylist(ArrayList<Integer> arrayIntList) {
        System.out.println("Maximal element of collection: " + Collections.max(arrayIntList));
        return Collections.max(arrayIntList);
    }

    public static int minValueOfArraylist(ArrayList<Integer> arrayIntList) {
        System.out.println("Minimal element of collection: " + Collections.min(arrayIntList));
        return Collections.min(arrayIntList);
    }

    public static double avgValueOfArraylist(ArrayList<Integer> arrayIntList) {
        int sumOfCollection = 0;
        for (int index : arrayIntList) {
            sumOfCollection = sumOfCollection + index;
        }
        System.out.println(arrayIntList);
        System.out.println("Sum of collection elements: " + sumOfCollection);
        System.out.println("Average of collection: " + (double) sumOfCollection / arrayIntList.size());
        return (double) sumOfCollection / arrayIntList.size();
    }

    public static int indexToValue(ArrayList<Integer> arrayIntList) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter index of collection to find element");
        int indexForFind = isInputInt();
        if (indexForFind > arrayIntList.size() - 1) {
            System.err.println("Eror input");
        } else
            System.out.println("Element in index " + indexForFind + " of collection -- " + arrayIntList.get(indexForFind));
        return arrayIntList.get(indexForFind);
    }

    public static void findValueInArrayList(ArrayList<Integer> arrayIntList) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter value to find in collection ");
        int numberForFind = isInputInt();
        int countOfNuberForFind = 0;
        for (int i = 0; i < arrayIntList.size(); i++) {
            if (arrayIntList.get(i).equals(numberForFind)) {
                System.out.println("Entered number find in index " + i);
                countOfNuberForFind++;
            }
        }
        if (countOfNuberForFind != 0) System.out.println("The entered numder occurs " + countOfNuberForFind + " times");
        else System.out.println("Enetered number is missing in collection");
    }

    public static boolean menuSelection(ArrayList arrayListOfInteger) throws Exception {
        if (arrayListOfInteger.size() > 0) {
            System.out.println("Enter number to select menu");
            System.out.println("**************************************************************");
            System.out.println("[1] - add elements to collection");
            System.out.println("[2] - remove elements to collection");
            System.out.println("[3] - find max element in collection");
            System.out.println("[4] - find min element in collection");
            System.out.println("[5] - find sum of elements and average value in collection");
            System.out.println("[6] - find value from index of collection");
            System.out.println("[7] - find element in collection");
            System.out.println("[0] - exit");
            System.out.println("**************************************************************");
            System.out.println("ArrayList: " + arrayListOfInteger);
            System.out.println("**************************************************************");
            int menuSelection = isInputInt();
            switch (menuSelection) {
                case 0:
                    return false;
                case 1:
                    addValueInArrayList(arrayListOfInteger);
                    return true;
                case 2:
                    removeValueFromArrayList(arrayListOfInteger);
                    return true;
                case 3:
                    minValueOfArraylist(arrayListOfInteger);
                    return true;
                case 4:
                    maxValueOfArraylist(arrayListOfInteger);
                    return true;
                case 5:
                    avgValueOfArraylist(arrayListOfInteger);
                    return true;
                case 6:
                    indexToValue(arrayListOfInteger);
                    return true;
                case 7:
                    findValueInArrayList(arrayListOfInteger);
                    return true;
                default:
                    System.out.println("Invalid menu selection");
                    return true;
            }
        } else {
            System.err.println("Invalid size of collection");
            return false;
        }

    }

    public static void main(String[] args) throws Exception {
        ArrayList arrayListOfInteger = createOfArrayList();
        while(menuSelection(arrayListOfInteger)) {
            menuSelection(arrayListOfInteger);
        }
    }
}
