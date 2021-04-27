import java.util.*;
class A {}
class B extends A {}
class Test7 {
     public static void m1(List<? extends A> list) {}
     public static void m2(List<A> list) {}
	 public static void m3(List<? super A> list) { }
     public static void main (String [] args) {
        List<A> listA = new ArrayList<A> ();
        List<B> listB = new ArrayList<B> ();
        List<Object> listO = new ArrayList<Object> ();
        m3(listO);
    }
}