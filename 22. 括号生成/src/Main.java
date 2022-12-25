import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        ["()"];
//        ["()(),(())"];
//        ["()()()","((()))","(()())","(())()","()(())"];

//        String[] strings = {"()()()()","(()()())","(()())()","()(()())","((()()))","(())()()","()(())()","((())())","()(())()","()()(())","(()(()))","((()))()","()((()))","(((())))"};
//        String[] strings = {"(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"};
//
//        List<String> strings = Solution.generateParenthesis(4);
        System.out.println(1);
    }
    static class Solution {
        public static List<String> generateParenthesis(int n) {
            List<String> l = new ArrayList<>();
            l.add("()");
            for (int i = 1; i < n; i++) {
                l = addOneParenthesis(l);
            }
            return l;
        }
        public static List<String> addOneParenthesis(List<String> list){
            List<String> resList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                int index = list.get(i).indexOf(")(");

            }
            return resList;
        }
    }
}