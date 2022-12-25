public class Main {
    public static void main(String[] args) {
        String s = "abbc";
        String[] ps = {"a.","a*","a.*","*a","ab*","*b*","*bb.","a**c"};
        for (int i = 0; i < ps.length; i++) {
//            System.out.println(Solution.isMatch(s,ps[i]));
        }
        System.out.println(Solution.isMatch("aab","c*a*b"));
    }
    static class Solution {
        static public boolean isMatch(String s, String p) {
            // 去除重复*
            while (p.contains("**")){
                p = p.replaceAll("[*][*]", "*");
            }
            int i = 0;
            int k = 0;
            for (; i < s.length(); i++) {
                if(k >= p.length()){
                    return false;
                }
                if(p.charAt(k + 1) == '*'){
                    if(k < p.length() - 1){
                        // * 有字符，将i定位到该字符
                        char t = p.charAt(k);
                        for (;i < s.length();i++){
                            if(s.charAt(i) == t){
                                i++;
                                k++;
                                break;
                            }
                        }
                    }else {
                        // * 是最后一个
                        i = s.length() - 1;
                        continue;
                    }
                }else {
                    if(p.charAt(k) == '.'){
                        k++;
                        continue;
                    }else {
                        if(s.charAt(i) == p.charAt(k)){
                            k++;
                            continue;
                        }else {
                            return false;
                        }
                    }
                }
            }
           return true;
        }
    }
}