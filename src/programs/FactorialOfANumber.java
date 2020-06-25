package programs;

public class FactorialOfANumber {
    public static void main(String[] args) {
        System.out.println(factorialOfANumber(3));
    }

    private static int factorialOfANumber(int number) {
        if (number < 1) {
            return 1;
        }
        return number * factorialOfANumber(number-1);
    }
}
