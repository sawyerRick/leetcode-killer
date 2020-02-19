package cn.sawyer.leetcode.greedy.maxProfit;

/**
 * @program: LeetCode
 * @description: 买股票的最佳时机，https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @author: sawyer
 * @create: 2019-12-20 20:51
 **/
public class Solution {

    // 贪心
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int min = prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                // 买
                min = prices[i];
            } else {
                // 卖
                ans = Math.max(ans, prices[i] - min);
            }
        }

        return ans;
    }

}
