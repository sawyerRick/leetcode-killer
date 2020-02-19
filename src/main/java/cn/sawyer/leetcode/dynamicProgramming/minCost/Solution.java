package cn.sawyer.leetcode.dynamicProgramming.minCost;

/**
 * @program: LeetCode
 * @description: 粉刷房子，https://leetcode-cn.com/problems/paint-house/
 * @author: sawyer
 * @create: 2020-02-19 15:23
 **/

// 二维DP
public class Solution {
    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }

        int len = costs.length;
        int[][] dp = new int[len][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < costs.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + costs[i][2];
        }

        return Math.min(Math.min(dp[len - 1][0], dp[len - 1][1]), dp[len - 1][2]);
    }

}