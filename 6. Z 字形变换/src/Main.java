public class Main {
    public static void main(String[] args) {
        String paypalishiring = Solution.convert("A", 1);
        System.out.println(paypalishiring);
    }
    static class Solution {
        public static String convert(String s, int numRows) {
            if(numRows == 1){
                return s;
            }
            int k = s.length();
            char[][] chars = new char[numRows][k];
            int n = 0;
            // j列
            int j = 0;
            while (n < s.length()){
                if (j % (numRows - 1) == 0) {
                    // 竖着放
                    for (int i = 0; i < numRows; i++) {
                        if (n < s.length()) {
                            chars[i][j] = s.charAt(n);
                            n++;
                        } else {
                            return printChars(chars);
                        }
                    }
                    j++;
                } else {
                    for (int i = numRows - 2; i > 0; i--) {
                        if (n < s.length()) {
                            chars[i][j] = s.charAt(n);
                            n++;
                            j++;
                        } else {
                            return printChars(chars);
                        }
                    }
                }
            }
            return printChars(chars);
        }
        public static String printChars(char[][] chars){
            StringBuffer s = new StringBuffer();
            int i = chars.length;
            int k = chars[0].length;
            for (int i1 = 0; i1 < i; i1++) {
                for (int i2 = 0; i2 < k; i2++) {
                    if(chars[i1][i2] == '\u0000'){
                        continue;
                    }
                    s.append(chars[i1][i2]);
                }
            }
            return s.toString();
        }
    }
}