
class Test{
    public static void main(String[] args) {
        test5();
    }
    public static void test1() {
        String[][] a = {
            {"Beijing", "Wuhan"},
            {"Shanghai", "Guangzhou", "Xian"},
            {"Chongqing", "Chengdu"}
        };
        System.out.println(a[a.length - 1].length);
        System.out.println(a[a.length - 1][a[a.length - 1].length - 1].length());
    }
    
    public static void test2() {
        String[] s = {"Monday", "Tuesday", "Wednesday", "Thirsday", "Friday", "Sataday", "Sunday"};
        int a = s.length;
        int b = s[1].length();
    }

    public static void test3() {
        int[] array = new int[10];
        increase(array);
        System.out.print(array[0]);
    }
    public static void increase(int[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i]++;
        }
    }

    public static void test4() {
        int a[] = null;
        int[] b = {};
        // int[] c = new int{1, 2, 3, 4};
        int[] d[] = new int[5][];
    }

    public static void test5() {
        int[] a = { 1 };
        String[] s = { "Hello" };
        int i = a[0];
        m(s,a,i);
        for(String v : s){
            System.out.println(v);
        }
        for(int v: a){
            System.out.println(v);
        }
        System.out.println(i);
    }
    public static void m(String[] a1, int[] a2, int i){
        for(int j =0; j < a1.length;j++){
            a1[j] = "Java";
        }
        for(int j =0; j < a2.length;j++){
            a2[j]++;
        }
        i++;
    }
}