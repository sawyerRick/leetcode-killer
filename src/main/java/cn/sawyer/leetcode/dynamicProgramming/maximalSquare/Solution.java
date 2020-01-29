package cn.sawyer.leetcode.dynamicProgramming.maximalSquare;

/**
 * @program: LeetCode
 * @description: 最大正方形，https://leetcode-cn.com/problems/maximal-square/solution/
 * @author: sawyer
 * @create: 2020-01-14 18:25
 **/
public class Solution {
    public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    System.out.println("a");
                    dp[i][j] = Math.min(Math.min(matrix[i][j - 1], matrix[i - 1][j]), matrix[i][j]) + 1;
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }

        return ans;
    }
}
