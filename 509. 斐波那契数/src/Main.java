public class Main {
    public static void main(String[] args) {
        int ans = Solution.fib(10);
    }

    static class Solution {
        public static int fib(int n) {
            int[] cache = new int[n + 1];
            return f(n, cache);
        }

        /**
         * 缓存递归
         * @param n n
         * @param cache 缓存
         * @return 结果
         */
        public static int f(int n, int[] cache) {
            if (n == 0) {
                return 0;
            }
            if (cache[n] != 0) {
                return cache[n];
            }
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 1;
            }
            cache[n] = f(n - 1, cache) + f(n - 2, cache);
            return cache[n];
        }
    }
}