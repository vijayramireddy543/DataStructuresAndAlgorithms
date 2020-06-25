package programs;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

public class SecondLargestElement {
    public static void main(String[] args) {
        List<Integer> intArray = new ArrayList<Integer>();
        intArray.add(10);
        intArray.add(7);
        intArray.add(6);
        intArray.add(18);
        sort(intArray);
        System.out.println(intArray.get(intArray.size()-2));
    }
}
