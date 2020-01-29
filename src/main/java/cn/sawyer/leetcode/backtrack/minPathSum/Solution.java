package cn.sawyer.leetcode.backtrack.minPathSum;

/**
 * @program: LeetCode
 * @description: 最小路径和 url:https://leetcode-cn.com/problems/minimum-path-sum/
 * @author: sawyer
 * @create: 2020-01-05 15:03
 **/

// 暴力回溯，超时
public class Solution {
    int min = Integer.MAX_VALUE;
    int[][] grid;
    int rowLen;
    int colLen;

    public void backtrack(int row, int col, int step) {
        // 右溢出
        if (col >= colLen) {
            return;
        }

        // 下溢出
        if (row >= rowLen) {
            return;
        }

        step += grid[row][col];
        // 一个结果
        if (row == rowLen - 1 && col == colLen - 1) {
            min = Math.min(min, step);
            return;
        }

        // 向右走
        backtrack(row, col + 1, step);
        // 回溯

        // 向下走
        backtrack(row + 1, col, step);
        // 回溯
    }


    // 暴力回溯
    public int minPathSum(int[][] grid) {
        this.grid = grid;
        this.rowLen = grid.length;
        this.colLen = grid[0].length;

        backtrack(0, 0, 0);

        return min;
    }

    // 动态规划
    public int minPathSum2(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (j != col - 1 && i == row - 1) {
                    // 最后一行的非最右列
                    dp[i][j] = dp[i][j + 1] + grid[i][j];
                } else if (i != row - 1 && j == col - 1) {
                    // 最右列的非最后行
                    dp[i][j] = dp[i + 1][j] + grid[i][j];
                } else if (i != row - 1 && j != col - 1){
                    // 其他
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                } else {
                    // 最后一个
                    dp[i][j] = grid[i][j];
                }
                System.out.println(dp[i][j]);
            }
        }


        return dp[0][0];
    }
}
