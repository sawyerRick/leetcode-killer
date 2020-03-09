package cn.sawyer.leetcode.dynamicProgramming.maximalRectangle;

import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 最大矩形，https://leetcode-cn.com/problems/maximal-rectangle/
 * @author: sawyer
 * @create: 2020-01-17 17:45
 **/
public class Solution {

    // 单调栈
    public int leetcode84(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        return maxarea;
    }

    // 用了'柱状图中最大矩形'的方法，遍历，用dp储存高度。
    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) return 0;
        int maxarea = 0;
        int[] dp = new int[matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {

                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            maxarea = Math.max(maxarea, leetcode84(dp));
        } return maxarea;
    }
}