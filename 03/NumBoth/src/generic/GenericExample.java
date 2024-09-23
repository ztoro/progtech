package generic;

import java.util.ArrayList;

public class GenericExample {

    // Generic method that works with any type T
    public static <T> int countItems(ArrayList<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
        return list.size(); // Returns the size of the collection
    }

    public static void main(String[] args) {
        ArrayList<String> stringCollection = new ArrayList<>();
        stringCollection.add("Hello");
        stringCollection.add("World");

        int stringCount = countItems(stringCollection); // Count of strings
        System.out.println("Count of strings: " + stringCount); // Output: 2

        ArrayList<Integer> integerCollection = new ArrayList<>();
        integerCollection.add(1);
        integerCollection.add(2);
        integerCollection.add(3);

        int intCount = countItems(integerCollection); // Count of integers
        System.out.println("Count of integers: " + intCount); // Output: 3
    }
}
