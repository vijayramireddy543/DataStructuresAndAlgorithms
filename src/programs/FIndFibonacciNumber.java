package programs;

import java.util.Arrays;

public class FIndFibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fibonacci(4));
    }
    //Sum of previous 2 number is fibonacci number
    private static int fibonacci(int number) {
        if (number <= 0) {
            throw new RuntimeException();
        }
        if (Arrays.asList(1, 2).contains(number)) {
            return number - 1;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}
