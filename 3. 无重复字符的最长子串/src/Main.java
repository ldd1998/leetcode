import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author ldd
 */
public class Main {
    public static void main(String[] args) {
        String s = "qrsvbspk";
        int i = Solution.lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    static class Solution {
        public static int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) {
                return 0;
            }
            if (s.length() == 1) {
                return 1;
            }
            int curRes = 0;
            int res = 0;
            Set<Character> set = new LinkedHashSet<>();
            int start = 0;
            int end = 0;
            while (start != s.length() - 1 && end <= s.length() - 1) {
                if (!set.add(s.charAt(end))) {
                    curRes = set.size();
                    set.remove(s.charAt(start));
                    start++;
                    if (curRes > res) {
                        res = curRes;
                    }
                    continue;
                }
                end++;
            }
            return res < set.size() ? set.size() : res;
        }
    }
}