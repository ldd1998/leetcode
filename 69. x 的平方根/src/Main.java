public class Main {
    public static void main(String[] args) {
        int i = Solution.mySqrt(2147483647);
        System.out.println(i);
    }

    static class Solution {
        public static int mySqrt(int x) {
            if (0 == x) {
                return 0;
            }
            if(46340*46340 < x){
                return 46340;
            }

            int left = 1;
            int right = 46340;
            int mid = right / 2;
            while (true) {
                if(mid * mid == x){
                    return mid;
                }else if (left * left == x){
                    return left;
                }else if (right * right == x){
                    return right;
                }else if(left == right || left + 1 == right){
                    return left;
                }

                mid = (right + left)/2;
                if (left * left < x && mid * mid > x) {
                    right = mid;
                }
                if (mid * mid < x && right * right > x) {
                    left = mid;
                }
            }
        }
    }
}