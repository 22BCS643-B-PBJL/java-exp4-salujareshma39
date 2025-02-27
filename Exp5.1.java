/* Easy Level:
Write a Java program to calculate the sum of a list of integers using autoboxing and unboxing. Include methods to parse strings into their respective wrapper classes (e.g., Integer.parseInt()).
*/
import java.util.ArrayList;

public class SumofInteger {
    public static void main(String[] args) {
        String[] numberStrings = {"10", "20", "30", "40", "50"};

        ArrayList<Integer> numbers = new ArrayList<>();
        for (String s : numberStrings) {
            numbers.add(Integer.parseInt(s));
        }

        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }

        System.out.println("Sum of integers: " + sum);
    }
}
