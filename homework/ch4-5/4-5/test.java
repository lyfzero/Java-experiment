
class test{
    public static void main(String[] args) {
        test3();
    }
    public static void test1() {
        String s1 = "Welcome to Java";
        String s2 = s1;
        String s3 = new String("Welcome to Java");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s3));
        System.out.println(s1.compareTo(s2));
        System.out.println(s2.compareTo(s3));
        System.out.println(s1.charAt(0));
        System.out.println(s1.indexOf('j'));
        System.out.println(s1.indexOf("to"));
        System.out.println(s1.lastIndexOf("o", 15));
        System.out.println(s1.substring(3, 11));
        System.out.println(s1.endsWith("Java"));
        System.out.println(s1.startsWith("wel"));
        System.out.println("   We come  ".trim());
        System.out.println(s1.toUpperCase());
        System.out.println(s1.replace('o', 'T'));
    }
    public static void test2() {
        StringBuffer s1 = new StringBuffer("Java");
        StringBuffer s2 = new StringBuffer("HTML");
        // s1.append("   is fun");
        // s1.append(s2);
        // s1.insert(2, "is fun");
        // s1.insert(1, s2);

        
        // char c = s1.charAt(2);
        // System.out.println(c);
        // int i = s1.length();
        // System.out.println(i);

        // s1.deleteCharAt(3);
        // s1.delete(1, 3);
        // s1.reverse();
        // s1.replace(1, 3, "Computer");

        // String s3 = s1.substring(1, 3);
        // System.out.println(s1);
        // System.out.println(s3);
        String s4 = s1.substring(2);
        System.out.println(s4);
        System.out.println(s1);
    }
    public static void test3() {
        String s1 = "Welcome";
        String s2 = new String("Welcome");
        String s3 = s2.intern();
        String s4 = "Wel" + "come";
        String s5 = "Wel";
        String s6 = "come";
        String s7 = s5 + s6;
        String s8 = "Wel" + new String("come");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        System.out.println(s1 == s7);
        System.out.println(s1 == s8);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s4));
        System.out.println(s1.equals(s7));
        System.out.println(s1.equals(s8));
    }
}