package rawtype;

import java.util.ArrayList;

public class RawType {
    public static int countStrings(ArrayList list) {
        int count = 0;
        for (Object obj : list) {
            // Attempting to treat every element as a String
            String str = (String) obj; // This is a dangerous cast
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Hello");
        list.add("World");
        list.add(42); // Adding an Integer

        int count = countStrings(list); // This will throw ClassCastException
        System.out.println("Count of strings: " + count);
    }
}
