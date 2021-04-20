public class Test8 {
    void test1() {
        int[] m = new int[5];
        m[5] = 10;
    }
    public void test2() {
        try {
            System.out.print("try.");        
            return;
        } catch(Exception e){
            System.out.print("catch.");
        }finally {
            System.out.print("finally.");
        }
    }
    public void m1() throws IOException{
        try {
            throw new IOException();
        }
        catch (IOException e){

        }
    }

    public void m2(){
        m1();
    }
    public static void main(String[] args) {
        
    }
}
