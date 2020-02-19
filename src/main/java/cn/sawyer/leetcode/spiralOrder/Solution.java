package cn.sawyer.leetcode.spiralOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 螺旋矩阵，https://leetcode-cn.com/problems/spiral-matrix/
 * @author: sawyer
 * @create: 2020-01-30 17:17
 **/
public class Solution {
    public List < Integer > spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0)
            return ans;
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            // 左到右
            for (int c = left; c <= right; c++) ans.add(matrix[top][c]);
            // 上到下
            for (int r = top + 1; r <= bottom; r++) ans.add(matrix[r][right]);
            // 判断是否需要继续
            if (top < bottom && left < right) {
                // 右到左
                for (int c = right - 1; c > left; c--) ans.add(matrix[bottom][c]);
                // 下到上
                for (int r = bottom; r > top; r--) ans.add(matrix[r][left]);
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return ans;
    }
}