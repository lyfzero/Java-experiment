import java.util.List;
import java.util.ArrayList;
class A {}
class B extends A {}
class C extends B {}
class D extends C {}
public class Test6 {
	public static <T> void m (List<? super T> list1, List<? extends T> list2) {}
    public static void main(String[] args) {
        // List<B> l1 = new ArrayList<> ();
        // List<B> l2 = new ArrayList<> ();
        // Test6.m(l1, l2);
        // List<B> l3 = new ArrayList<> ();
        // List<D> l4 = new ArrayList<> ();
        // Test6.m (l3, l4);
        // List<B> l5 = new ArrayList<> ();
        // List<A> l6 = new ArrayList<> ();
        // Test6.m (l5, l6);
        // List<C> l7 = new ArrayList<> ();
        // List<D> l8 = new ArrayList<> ();
        // Test6.m (l7, l8);
        // List<C> l7 = new ArrayList<> ();
        // List<D> l8 = new ArrayList<> (); 
        // Test6.<B>m (l7, l8);
        List<D> l9 = new ArrayList<> ();
        List<C> l10 = new ArrayList<> ();
        Test6.m (l9, l10);

    } 
}