import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class generateNumber {
    public static void main(String[] args) {
        Map<String, Boolean> strBoMap = new HashMap<String, Boolean>();
        String[] res = new String[5];
        for (int i = 0; i < 5; i++) {
            res[i] = "";
            String temp = generateCard();
            while (strBoMap.containsKey(temp) == true) {
                temp = generateCard();
            }
            strBoMap.put(temp, true);
            res[i] += temp;
        }
        for(String s:res){
            System.out.println(s);
        }
    }
    public static String generateCard() {
        String res = "";
        for (int i = 0; i < 3; i++) {
            res += String.valueOf((char) ('A' + (int) (Math.random() * 26)));
        }
        for (int i = 0; i < 4; i++) {
            res += String.valueOf((int) (Math.random() * 10));
        }
        return res;
    }
}
