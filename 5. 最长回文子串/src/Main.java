/**
 * @author ldd
 */
public class Main {
    public static void main(String[] args) {
//        String s = "atttta";
        String s = "cbbd";
        String s1 = Solution.longestPalindrome(s);
        System.out.println(s1);
    }

    static class Solution {
        public static String longestPalindrome(String s) {
            if(s == null || s.length() == 0){
                return "";
            }
            String palindromeStr = "";
            for (int i = 0; i < s.length(); i++) {
                String palindromeStr1 = ifPalindrome(s, String.valueOf(s.charAt(i)),i,i);
                String palindromeStr2 = "";
                if(i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)){
                     palindromeStr2 = ifPalindrome(s, s.charAt(i) + String.valueOf(s.charAt(i + 1)),i,i + 1);
                }
                String palindromeStr3 = palindromeStr1.length() > palindromeStr2.length() ? palindromeStr1 : palindromeStr2;
                palindromeStr = palindromeStr.length()>palindromeStr3.length()?palindromeStr:palindromeStr3;
            }
            return palindromeStr;
        }

        static String ifPalindrome(String s,String palindromeStr, int left,int right) {
            while (left >= 1 && right < s.length() - 1) {
                left = left - 1;
                right = right + 1;
                if (s.charAt(left) == s.charAt(right)) {
                    palindromeStr = palindromeStr + s.charAt(right);
                    palindromeStr = s.charAt(left) + palindromeStr;
                } else {
                    return palindromeStr;
                }
            }
            return palindromeStr;
        }
    }
}