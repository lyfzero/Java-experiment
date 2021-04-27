import java.util.ArrayList;
import java.util.List;
class Shape {}
class Circle extends Shape {}
class Triangle extends Shape {}
public class Test4 {
    public static void main (String [] args) {
        List<? extends Shape> list1 = new ArrayList< Triangle> ();
        List<? extends Shape> list2 = new ArrayList<Circle> ();

        // System.out.println(list1 instanceof List< Triangle>);
        System.out.println(list2 instanceof List);
        System.out.println(list1.getClass() == list2.getClass());
    }
}