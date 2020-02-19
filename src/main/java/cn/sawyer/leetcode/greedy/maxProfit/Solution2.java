package cn.sawyer.leetcode.greedy.maxProfit;

/**
 * @program: LeetCode
 * @description: 买股票的最佳时机2，https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @author: sawyer
 * @create: 2020-02-08 18:05
 **/
// 允许多次买卖
public class Solution2 {

    // 贪心解法
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                ans += prices[i + 1] - prices[i];
            }
        }

        return ans;
    }

    // 找峰值解法
    public int maxProfit2(int[] prices) {
        int profit = 0;
        int low = prices[0];
        int height = prices[0];

        int i = 0;
        while (i < prices.length - 1) {
            // 下坡
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]){
                i++;
            }
            low = prices[i];
            // 上坡
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            height = prices[i];
            profit += height - low;
        }

        return profit;
    }
}
