package cn.sawyer.leetcode.dynamicProgramming.uniquePathsWithObstacles;

import java.net.Socket;
import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 不同路径2，https://leetcode-cn.com/problems/unique-paths-ii/
 * @author: sawyer
 * @create: 2020-01-07 14:26
 **/
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 0);
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.uniquePathsWithObstacles(new int[10][10]);
    }
}
