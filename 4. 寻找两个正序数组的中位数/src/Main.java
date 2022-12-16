public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4};
        int[] nums2 = {1, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4};

        double medianSortedArrays = Solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    static class Solution {
        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] temp = new int[nums1.length + nums2.length];
            int i = 0;
            int j = 0;
            int k = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    temp[k] = nums1[i];
                    i++;
                    k++;
                } else if (nums1[i] > nums2[j]) {
                    temp[k] = nums2[j];
                    j++;
                    k++;
                } else {
                    temp[k] = nums1[i];
                    i++;
                    k++;
                    temp[k] = nums2[j];
                    j++;
                    k++;
                }
            }
            if (i < nums1.length) {
                for (; i < nums1.length; i++) {
                    temp[k] = nums1[i];
                    k++;
                }
            }
            if (j < nums2.length) {
                for (; j < nums2.length; j++) {
                    temp[k] = nums2[j];
                    k++;
                }
            }
            if (nums1.length == 0 && nums2.length == 0) {
                return 0;
            }
            double d = (temp[temp.length / 2] + temp[(temp.length - 1) / 2]) / 2D;
            return d;
        }
    }
}