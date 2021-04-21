public class Test {
    public static void main(String[] args) {
        System.out.println(new AA(10).AA(20));
    }
}
class AA {
    private long i = 0;
    AA(int i) {
        this.i = i;
    }
    String AA(long i) {
        this.i = i;
        return "i = " + this.i;
    }
}