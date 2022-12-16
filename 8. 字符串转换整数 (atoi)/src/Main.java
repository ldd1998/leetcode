import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String s = "-01";
        /**
         * 1 = 49;
         */
        int i = Solution.myAtoi(s);
        System.out.println(i);
    }

    static class Solution {
        public static int myAtoi(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }
            List<Character> resChars = new ArrayList();
            boolean flag = true;// 正数
            // 丢弃无用的前导空格
            while (s.length() != 0 && s.charAt(0) == ' '){
                s = s.substring(1, s.length());
            }
            // 判断正负
            if(s.length() != 0 && s.charAt(0) == '-'){
                s = s.substring(1,s.length());
                flag = false;
            }else if(s.length() != 0 && s.charAt(0) == '+'){
                s = s.substring(1,s.length());
            }
            // 去除前导0
            while (s.length() != 0 && s.charAt(0) == '0'){
                s = s.substring(1, s.length());
            }
            // 将是数字的存入list
            for (int i = 0; i < s.length(); i++) {
                // 是否为数字
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    resChars.add(s.charAt(i));
                }else {
                    break;
                }
            }
            // 将list转为数字
            int resLength = resChars.size();
            // 判断是否超过int长度
            if(resLength > 12){
                if(flag == true){
                    return Integer.MAX_VALUE;
                }else {
                    return Integer.MIN_VALUE;
                }
            }else if(resLength == 0){
                return 0;
            }
            long res = 0;
            for (int i = 0; i < resLength; i++) {
                res += (resChars.get(i) * 1 - 48) * Math.pow(10,resLength - i - 1);
            }
            if(flag == true){
                if(res > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                return (int)res;
            }else {
                 res = res - res*2;
                if(res < Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
                return (int)res;
            }
        }
    }
}