package test;
import java.util.Scanner;
public class Test
public class TestScanner {
    public static void main(String[ ] args) {
        // Create a scanner
        Scanner scanner = new Scanner(System.in);
        // Prompt the user to enter an integer
        System.out.print("Enter an integer: ");
        int intValue = scanner.nextInt();
        System.out.println("You entered the integer: " + intValue);
        // Prompt the user to enter a double value
        System.out.print("Enter a double value: ");
        double doubleValue = scanner.nextDouble();
        System.out.println("You entered the double value: " + doubleValue);
        System.out.print("Enter a string without space: ");
        String string = scanner.next();
        System.out.println("You entered the string: " + string);
    }
}