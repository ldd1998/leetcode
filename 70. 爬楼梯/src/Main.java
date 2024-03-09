public class Main {
    public static void main(String[] args) {
        System.out.println(climbStairs(6));
    }
    public static int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return climbStairs(n, memo);
    }

    public static int climbStairs(int n, int memo[]) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        // 如果memo[n]为0，说明还没计算过这个值
        if (memo[n] == 0) {
            memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
        }
        // 这个值在备忘录中，返回之
        return memo[n];
    }
}