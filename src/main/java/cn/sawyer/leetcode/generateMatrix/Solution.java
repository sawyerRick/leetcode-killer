package cn.sawyer.leetcode.generateMatrix;

/**
 * @program: LeetCode
 * @description: 螺旋矩阵2，https://leetcode-cn.com/problems/spiral-matrix-ii/
 * @author: sawyer
 * @create: 2020-02-17 16:22
 **/
public class Solution {
    public int[][] generateMatrix(int n) {
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        int[][] ans = new int[n][n];
        int num = 1;
        int tar = n * n;

        while(num <= tar){
            for(int i = left; i <= right; i++) ans[top][i] = num++; // left to right.
            top++;
            for(int i = top; i <= bottom; i++) ans[i][right] = num++; // top to bottom.
            right--;
            for(int i = right; i >= left; i--) ans[bottom][i] = num++; // right to left.
            bottom--;
            for(int i = bottom; i >= top; i--) ans[i][left] = num++; // bottom to top.
            left++;
        }

        return ans;
    }
}
