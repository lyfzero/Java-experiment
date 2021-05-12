import java.util.Scanner;
class Test {
    public static void main(String[] args) {
        // System.out.println(56 %6);
        // System.out.println(78 %-4);
        // System.out.println(-34 %5);
        // System.out.println(-34 %-5);
        // System.out.println(5 % 1);
        // System.out.println(1 % 5);
        double radius = 1;
        double area;
        final double PI = 3.14159;

        if (radius >= 0) {
            area = radius * radius * PI;
            System.out.println("The area for the circle of radius " 
              + radius + " is " + area);
          }
    }
}
    