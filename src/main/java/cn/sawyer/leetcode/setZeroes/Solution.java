package cn.sawyer.leetcode.setZeroes;

/**
 * @program: LeetCode
 * @description: 矩阵置零，https://leetcode-cn.com/problems/set-matrix-zeroes/
 * @author: sawyer
 * @create: 2020-01-20 18:32
 **/
public class Solution {

    public void setZeroes(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    System.out.println(i + "," + j);
                    row[i] = 1;
                    col[i] = 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println(col[j]);
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
