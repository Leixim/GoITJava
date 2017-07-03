package module03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class InputQueue {
    private static int readInt() throws Exception {
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
        Iterator<Integer> iterator = arrayList.iterator();

        while (iterator.hasNext()) {
            while (arrayList.size() < 16) {
                int value = readInt();
                if (value > 9 || value < -1) {
                    throw new InvalidValueOfCollection("Invalid input value (value > 9)");
                }
                if (value != -1) {
                    arrayList.add(value);
                    System.out.println(arrayList);
                } else {
                    return arrayList;
                }
            }
            int value = readInt();
            arrayList.remove(0);
            if (value != -1) {
                arrayList.add(value);
                System.out.println(arrayList);
            } else {
                return arrayList;
            }
        }
        return arrayList;
    }


    public static ArrayList<Integer> createOfArrayList() throws Exception {
        Random generator = new Random();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter size of collection ");
        int sizeOfCollection = readInt();
        if (sizeOfCollection <= 0 || sizeOfCollection > 16) {
            throw new InvalidSizeOfCollection("Size of collection is incorrect");
        } else {
            ArrayList<Integer> arrayIntList = new ArrayList();
            for (int i = 0; i < sizeOfCollection; i++) {
                arrayIntList.add(generator.nextInt(9));
            }
            System.out.println(arrayIntList);
            return arrayIntList;
        }
    }


    public static void main(String[] args) throws Exception {
        ArrayList arrayListOfInteger = createOfArrayList();
        addValueInArrayList(arrayListOfInteger);
    }

    static class InvalidSizeOfCollection extends Exception {
        public InvalidSizeOfCollection(String message) {
            super(message);
            System.err.println("*****************");
        }
    }

    static class InvalidValueOfCollection extends Exception {
        public InvalidValueOfCollection(String message) {
            super(message);
            System.err.println("*****************");
        }
    }
}
