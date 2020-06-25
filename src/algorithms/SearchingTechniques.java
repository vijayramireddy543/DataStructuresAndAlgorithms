package algorithms;

public class SearchingTechniques {
    public static void main(String[] args) {
        int[] array = {5, 9, 10, 20, 65};
        //System.out.println(binarySearch(9, array, array.length));
        System.out.println(linearSearch(20, array, array.length));

    }

    public static int binarySearch(int search, int[] array, int n) {
        int low = 0, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == search) {
                return mid;
            } else if (array[mid] < search) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static int linearSearch(int search, int[] array, int n) {
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (array[i] == search) {
                return i;
            }
        }
        return index;
    }
}
