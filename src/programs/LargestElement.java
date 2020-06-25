package programs;

public class LargestElement {

    public static void main(String[] args) {
        int[] intArray = {2, 9, 10, 5};
        int[] intArray1 = new int[4];
        int j = 1;
        int k = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] % 2 == 0) {
                intArray1[k++] = intArray[i];
                System.out.println("Even obj "+intArray[i]+  " "+k);
            } else {
                System.out.println(intArray[i] + "  " + i + "  " + (intArray.length - i));
                intArray1[intArray.length - j] = intArray[i];
                j++;
            }
        }
        for (int i = 0; i < intArray1.length; i++) {
            System.out.print(" " + intArray1[i]);
        }

    }
}
