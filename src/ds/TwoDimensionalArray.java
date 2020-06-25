package ds;

public class TwoDimensionalArray {
    static int[][] array = null;

    public static void main(String[] args) {
        initialiseArray(3, 3);
        //traverseArray();
        insertValueToTheArray(8, 1, 1);
        insertValueToTheArray(9, 2, 1);
        insertValueToTheArray(6, 1, 2);
        traverseArray();
        System.out.println("  ");
        searchValue(6);
        deleteValue(4, 2);
        deleteThisArray();
        traverseArray();

    }

    private static void deleteThisArray() {
        array = null;
    }

    private static void deleteValue(int row, int col) {
        try {
            if (array[row][col] != Integer.MIN_VALUE) {
                array[row][col] = Integer.MIN_VALUE;
            }
        } catch (RuntimeException ex) {
            System.out.println("Index not found " + ex);
        }
    }

    private static void searchValue(int val) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == val) {
                    System.out.println("Element found at row: " + i + "  " + j + "  value " + val);
                    return;
                }
            }
        }
    }

    private static void initialiseArray(int row, int col) {
        array = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int i1 = 0; i1 < col; i1++) {
                array[i][i1] = Integer.MIN_VALUE;
            }
        }
    }

    private static void traverseArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("  ");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(" | " + array[i][j]);
            }
        }
    }

    private static void insertValueToTheArray(int val, int row, int col) {
        if (array.length >= row && array[row][col] == Integer.MIN_VALUE) {
            array[row][col] = val;
        }
    }
}
