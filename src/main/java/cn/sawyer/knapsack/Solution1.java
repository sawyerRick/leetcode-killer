package cn.sawyer.knapsack;

/**
 * @program: LeetCode
 * @description: 01背包问题1
 * @author: sawyer
 * @create: 2020-03-29 17:50
 **/
public class Solution1 {

    // dp[i]：
    public int knapsack(int W, int N, int[] weights, int[] values) {
        int[] dp = new int[W + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = W; j >= 1; j--) {
                if (j >= w) {
                    dp[j] = Math.max(dp[j], dp[j - w] + v);
                }
            }
        }
        return dp[W];
    }
}
