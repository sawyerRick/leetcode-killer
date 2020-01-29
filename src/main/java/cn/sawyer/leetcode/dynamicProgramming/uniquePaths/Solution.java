package cn.sawyer.leetcode.dynamicProgramming.uniquePaths;

/**
 * @program: LeetCode
 * @description: 不同路径 https://leetcode-cn.com/problems/unique-paths/
 * @author: sawyer
 * @create: 2020-01-07 14:19
 **/
public class Solution {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
