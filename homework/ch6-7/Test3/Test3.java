import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        if(row <= 0) {
            System.out.println("Input a integer greater than 0");
            return;
        }
        int[][] list = createArray(row);
        printArray(list);
    }
    /**
     *  创建一个不规则二维数组
     *  第一行row列
     *  第二行row - 1列
     *  ...
     *  最后一行1列
	 *	数组元素值都为默认值
     * @param row 行数
     * @return 创建好的不规则数组
     */
    public static  int[][] createArray(int row){
        int[][] list = new int[row][];
        for(int i = 0; i < row; i++) {
            list[i] = new int[row - i];
        }
        return list;
    }

    /**
     * 逐行打印出二维数组，数组元素之间以空格分开
     * @param a
     */
    public static  void printArray(int[][] a){
        int row = a.length;
        for(int i = 0; i < row; i++) {
            int col = a[i].length;
            for(int j = 0; j < col; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

}