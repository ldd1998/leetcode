public class Main {
    public static void main(String[] args) {
        int[] nums1 = {2, 0};
        int m = 1;
        int[] nums2 = {1};
        int n = 1;
        Solution.merge(nums1, m, nums2, n);
    }

    static class Solution {
        public static void merge(int[] nums1, int m, int[] nums2, int n) {
            if (n == 0) {
                return;
            }
            int i = 0;
            int k = 0;
            while (i < m || m == 0) {
                while (k < n) {
                    if (nums2[k] < nums1[i] || i == m) {
                        // 插入到i，然后后移
                        insert(nums1, nums2[k], i, m);
                        k++;
                        i++;
                        m++;
                    } else {
                        i++;
                    }
                }
                i++;
            }
        }

        public static void insert(int[] nums1, int target, int insertCount, int m) {
            for (int i = m; i > insertCount; i--) {
                nums1[i] = nums1[i - 1];
            }
            nums1[insertCount] = target;
        }
    }
}