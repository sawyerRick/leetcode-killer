package cn.sawyer.leetcode.greedy.maxProfit;

/**
 * @program: LeetCode
 * @description: 买股票的最佳时机 url:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @author: sawyer
 * @create: 2019-12-20 20:51
 **/
// 贪心算法，局部最优达到全局最优
public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int low = prices[0];
        int height = prices[0];

        int i = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]){
                i++;
            }
            low = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            height = prices[i];
            profit += height - low;
        }


        System.out.println(profit);
        return profit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }
}
