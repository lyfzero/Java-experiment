import java.util.ArrayList;
class GeometricObject {}
class PolyGon extends GeometricObject {}
class Rectangle extends PolyGon {}
public class Test1 {
    public static void main(String[] args) {
        // ArrayList<String> lists = new ArrayList<String>();
        // ArrayList<? extends Object> lists = new ArrayList<String>();
        // ArrayList<? super String> lists = new ArrayList<Object>();
        // ArrayList<String> lists = new ArrayList<>();
        ArrayList<?> lists = new ArrayList<String>();
    }

    public void test1() {
        GeometricObject o = new Rectangle();
        // Class clz1 = o.getClass ();
        System.out.println(o.getClass().getSimpleName());

        Class<PolyGon> clz3 = null;
        clz3 = PolyGon.class;
        // clz3 = Rectangle.class; 

        Class<? extends PolyGon> clz4 = null;
        // clz4 = GeometricObject.class;
        clz4 = PolyGon.class;
        clz4 = Rectangle.class;
    }

}