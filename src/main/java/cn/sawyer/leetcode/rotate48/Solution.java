package cn.sawyer.leetcode.rotate48;

/**
 * @program: LeetCode
 * @description: 旋转图像 url:https://leetcode-cn.com/problems/rotate-image/
 * @author: sawyer
 * @create: 2019-12-30 13:48
 **/
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // transpose matrix 转置
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // reverse each row 翻转行
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][ n - j - 1 ];
                matrix[i][n - j - 1] = tmp;

            }
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rotate(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});

    }

    public void display(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
