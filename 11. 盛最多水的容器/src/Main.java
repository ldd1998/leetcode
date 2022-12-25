import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

public class Main {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int i = Solution.maxArea(height);
        System.out.println(i);
    }
    static class Solution {
        public static int maxArea(int[] height) {
            int maxArea = 0;
            for (int i = 0; i < height.length; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    int tempArea = (j - i) * (height[i] < height[j] ? height[i]:height[j]);
                    if(tempArea > maxArea){
                        maxArea = tempArea;
                    }
                }
            }
            return maxArea;
        }
    }
}