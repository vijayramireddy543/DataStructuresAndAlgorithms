package programs.string;

public class StringTest {

    public static void main(String[] args) {
        String s1 = new String("vijay");
        String s2 = new String("vijay");
        System.out.println("Test equality " + (s1 == s2) + "  " + s1.equals(s2));
    }
}
