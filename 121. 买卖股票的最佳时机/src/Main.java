import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        Solution.maxProfit(prices);
    }
}
class Solution {
    public static int maxProfit(int[] prices) {
        int min = 0;
        int max = 0;
        List<Integer> prices2 = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            prices2.add(prices[i]);
        }
        Collections.sort(prices2);

        return 0;
    }
}