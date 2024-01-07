import java.util.*;

/**
 * 杨辉三角
 */
public class Main {
    public static void main(String[] args) {
//        System.out.println(Solution.generate(1));
//        System.out.println(Solution.generate(2));
        System.out.println(Solution.generate(3));
        System.out.println(Solution.generate(4));
        System.out.println(Solution.generate(5));
    }
    static class Solution {
        public static List<List<Integer>> generate(int numRows) {
            if(numRows == 1){
                List<Integer> list = Arrays.asList(1);
                List<List<Integer>> ans = new ArrayList<List<Integer>>();
                ans.add(list);
                return ans;
            }
            if(numRows == 2){
                List<Integer> list1 = Arrays.asList(1);
                List<Integer> list2 = Arrays.asList(1,1);
                List<List<Integer>> ans = new ArrayList<List<Integer>>();
                ans.add(list1);
                ans.add(list2);
                return ans;
            }
            // 前面的list
            List<List<Integer>> lastList = generate(numRows - 1);
            // 拼装当前list
            List<Integer> numRowsList = new ArrayList<Integer>();
            // 开头
            numRowsList.add(1);
            for (int i = 0; i < lastList.size() - 1; i++) {
                List<Integer> list = lastList.get(lastList.size() - 1);
                numRowsList.add(list.get(i) + list.get(i + 1));
            }
            // 结尾
            numRowsList.add(1);
            lastList.add(numRowsList);
            return lastList;
        }
    }
}
