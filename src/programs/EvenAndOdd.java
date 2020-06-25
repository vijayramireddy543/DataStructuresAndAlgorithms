package programs;

public class EvenAndOdd {

    public static void main(String[] args) {
        int[] intArray = {4, 8, 2, 9, 10, 3};
        int[] intArray2 = new int[intArray.length];
        int even = 0;
        int odd = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        int j = 0, k = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] % 2 == 0) {
                intArray2[j++] = intArray[i];
            } else {
                intArray2[(intArray.length - odd) + k++] = intArray[i];
            }
        }
        for (int i = 0; i < intArray2.length; i++) {
            System.out.println(intArray2[i]);
        }
    }
}
