package cn.sawyer.leetcodeOffer.maxProfit;

/**
 * @program: LeetCode
 * @description: 股票的最大利润，https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 * @author: sawyer
 * @create: 2020-02-15 16:56
 **/
public class Solution {

    public int maxProfit(int[] prices) {

        int max = 0;
        int low = prices[0];

        for (int i = 0; i < prices.length; i++) {
            max = Math.max(prices[i] - low, max);

            low = Math.min(low, prices[i]);
        }

        return max;
    }
}
