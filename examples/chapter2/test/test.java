import java.util.Scanner;
class Test {
    public static void main(String[] args) {
        System.out.print("Please input your choice[1,2]:");
        long i = new Scanner(System.in).nextLong();
        switch (i){
            case 1 :
                System.out.println("Your choice is 1");
                break;
            case 2 :
                System.out.println("Your choice is 2");
                break;
            default:
                System.out.println("Wrong choice");
        }
    }
}
    