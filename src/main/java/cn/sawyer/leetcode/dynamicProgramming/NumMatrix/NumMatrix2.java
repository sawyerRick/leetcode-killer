package cn.sawyer.leetcode.dynamicProgramming.NumMatrix;

/**
 * @program: LeetCode
 * @description: 二维区域检索-可变，https://leetcode-cn.com/problems/range-sum-query-2d-mutable/
 * @author: sawyer
 * @create: 2020-02-19 21:01
 **/
public class NumMatrix2 {

    int[][] dp;
    int[][] matrix;


    public NumMatrix2(int[][] matrix) {
        this.matrix = matrix;
        if (matrix.length == 0) {
            return;
        }
        dp = new int[matrix.length][matrix[0].length + 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                dp[i][j + 1] = dp[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;

        for (int i = row1; i <= row2; i++) {
            sum += dp[i][col2 + 1] - dp[i][col1];
        }

        return sum;
    }

    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        matrix[row][col] = val;

        for (int i = col; i < dp.length; i++) {
            dp[row][i + 1] += diff;
        }
    }
}
