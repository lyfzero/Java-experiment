public class testabc {
    public static void main(String args[]) {
        A a = new A();
        B b = a;
        C c1 = a, c2 = new A();
    }
}
class A extends B implements C {
    public A() {
        System.out.println("constructor A");
    }
}
class B {
    public B() {
        System.out.println("constructor B");
    }
}
interface C {

}