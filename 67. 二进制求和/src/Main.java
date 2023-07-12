import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ldd
 */
public class Main {
    public static void main(String[] args) {
        String s = Solution.addBinary("1", "1");
        System.out.println(s);
    }

    static class Solution {
        public static String addBinary(String a, String b) {

            Map<String, Integer> resMap = new LinkedHashMap<>();
            String res = "";
            int maxLength = Math.max(a.length(), b.length());
            if (a.length() == maxLength){
                int headB = (maxLength - b.length());
                for (int i = 0; i < headB; i++) {
                    b= "0" + b;
                }
            }else {
                int headA = (maxLength - a.length());
                for (int i = 0; i < headA; i++) {
                    a = "0" + a;
                }
            }
            for (int i = maxLength - 1; i >= 0; i--) {
                int cur = 0;
                if (i < a.length() && i < b.length()) {
                    cur = (Integer.parseInt(String.valueOf(a.charAt(i))) + Integer.parseInt(String.valueOf(b.charAt(i))));
                }
                if (resMap.containsKey(i + "")) {
                    cur += resMap.get(i + "");
                }
                if (cur == 2) {
                    resMap.put(i + "", 0);
                    resMap.put((i - 1) + "", 1);
                } else if (cur == 3) {
                    resMap.put(i + "", 1);
                    resMap.put((i - 1) + "", 1);
                } else {
                    resMap.put(String.valueOf(i), cur);
                }
                res = resMap.get(i + "") + res;
                if (i == 0 && resMap.containsKey(i - 1 + "")) {
                    res = resMap.get(i - 1 + "") + res;
                }
            }
            return res;
        }
    }
}