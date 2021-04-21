import java.util.Scanner;

public class countChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] charCNT = new int[26];
        System.out.println("input a string:");
        String str = sc.nextLine();
        str = str.trim().toLowerCase();
        int len = str.length();
        for(int i = 0; i < len; i++) {
            char c = str.charAt(i);
            charCNT[c - 'a']++;
        }
        for(int i = 0; i < charCNT.length; i++) {
            if(charCNT[i] != 0) {
                System.out.println((char)(i + 'a') + ": " + charCNT[i]);
            }
        }
    }
}