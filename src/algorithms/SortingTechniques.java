package algorithms;

public class SortingTechniques {
    public static void main(String[] args) {
        int[] array = {78, 12, 56, 90, 25, 5, 2, 20, 80, 12};
        //bubbleSort(array);
        quickSortMiddleElement(array, 0, array.length-1);
        //selectionSort(array);
        //insertionSort(array);
        //quicksort(array, 0, array.length - 1);
        //mergeSort(array, 0, array.length - 1);
        for (int value : array) {
            System.out.println(value);
        }
    }

    //O(n2)
    public static void bubbleSort(int[] array) {
        boolean sorted = false;
        for (int i = 0; i < array.length - 1; i++) {
            if (!sorted) {
                sorted = true;
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        sorted = false;
                    }
                }
            }
        }
    }

    public static void selectionSort(int[] array) {
        //78, 12, 56, 90, 25
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length - 1; j++) {
                if (array[j + 1] < array[minIndex]) {
                    minIndex = j + 1;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;

        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int sortedElement = array[i];
            int j = i - 1;
            while (j >= 0 && sortedElement < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = sortedElement;
        }
    }

    public static void quicksort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quicksort(array, low, pivot - 1);
            quicksort(array, pivot + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (pivot >= array[j]) {
                i++;
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    //O(nlogn)
    public static void mergeSort(int[] array, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[low + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = array[mid + 1 + i];
        }
        int i = 0, j = 0;
        int k = low;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < n1) {
            array[k++] = leftArray[i++];
        }
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }

    public int partitionForMiddleElement(int[] arr, int left, int right) {
        int i = left, j = right;
        int pivot = arr[(left + right) / 2];
        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                int tmp = arr[i];
                arr[i++] = arr[j];
                arr[j--] = tmp;
            }
        }
        return i;
    }

    public static void quickSortMiddleElement(int[] arr, int left, int right) {
        int pivot = partition(arr, left, right);
        if (left < pivot - 1)
            quickSortMiddleElement(arr, left, pivot - 1);
        if (pivot < right)
            quickSortMiddleElement(arr, pivot, right);
    }

}
