public class Test2 {
    public static void main(String[] args) {
        // Holder<String> h1 = new Holder<>("aaa");
        // String s1 = h1.getValue ();
        // System.out.println(s1);

        // RawHolder h1 = new RawHolder("aaa");
        // String s1 = (String)h1.getValue();
        // System.out.println(s1);

        // Holder<String> h1 = new Holder<> (Integer.valueOf(111));  
        // String s1 = h1.getValue();
        // System.out.println(s1);

        RawHolder h1 = new RawHolder (Integer.valueOf(111));
        String s1 = (String)h1.getValue();
        System.out.println(s1);
    }
}
class Holder<T> {
    T value;
    public Holder (T value) {this.value = value;}
    public T getValue () {return value;}
}

class RawHolder {
    Object value;
    public RawHolder (Object value) {this.value = value;}
    public Object getValue () {return value;}
}