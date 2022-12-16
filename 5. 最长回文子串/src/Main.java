import java.util.TreeMap;

/**
 * @author ldd
 */
public class Main {
    public static void main(String[] args) {
        String s = "atttta";
        String s1 = Solution.longestPalindrome(s);
        System.out.println(s1);
    }

    static class Solution {
        public static String longestPalindrome(String s) {
            if (s.length() == 0) {
                return "";
            }
            int mid = 0;
            TreeMap<Integer, String> map = new TreeMap<>();
            while (mid < s.length()) {
                int left = mid;
                int right = mid;
                while ((left >= 0 && right < s.length()) && s.charAt(left) == s.charAt(right)) {
                    // 是回文数
                    map.put(right + 1 - left, s.substring(left, right + 1));
                    left--;
                    right++;
                }
                left = mid - 1;
                right = mid;
                while ((left >= 0 && right < s.length()) && s.charAt(mid) == s.charAt(left)) {
                    // 是回文数
                    map.put(right + 1 - left, s.substring(left, right + 1));
                    left--;
                    right++;
                    if ((left >= 0 && right < s.length()) && s.charAt(left) == s.charAt(right)) {
                        // 还是回文数
                        map.put(right + 1 - left, s.substring(left, right + 1));
                        right++;
                        left--;
                    }
                }
                left = mid;
                right = mid + 1;
                while ((left >= 0 && right < s.length()) && s.charAt(mid) == s.charAt(right)) {
                    // 是回文数
                    map.put(right + 1 - left, s.substring(left, right + 1));
                    right++;
                    left--;
                    if ((left >= 0 && right < s.length()) && s.charAt(left) == s.charAt(right)) {
                        // 还是回文数
                        map.put(right + 1 - left, s.substring(left, right + 1));
                        right++;
                        left--;
                    }
                }
                mid++;
            }
            return map.get(map.lastKey());
        }
    }
}