import java.util.ArrayList;
import java.util.List;
public class Test5 {
    public static void main(String[] args) {
        List<? super Integer> x1 = new ArrayList<Number> ();
        // List<? super Number> x2 = new ArrayList<Integer> ();
        // List<? super Number> x3 = new ArrayList<Short> ();
        // List<? super Integer> x4 = new ArrayList<Short> ();
        List<? extends Number> x5 = new ArrayList<Integer> ();
        // List<? extends Number> x6 = new ArrayList<Object> ();
        List<Number> x7 = new ArrayList<> ();
        List<? extends Comparable<Double>> x8 = new ArrayList<Double> ();
        // List<? extends Number> x9 = new ArrayList<int> ();
    }
}
