package cn.sawyer.leetcode.dynamicProgramming.largestRectangleArea;

import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 再写一遍单调栈
 * @author: sawyer
 * @create: 2020-03-03 14:43
 **/
public class Solution2 {

    // 单调递增
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return -1;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // 垫底
        int max = 0;
        int curr = 0;
        while (curr < heights.length) {
            // 非递增
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[curr]) {
                int high = heights[stack.pop()];
                int width = curr - stack.peek() - 1;
                max = Math.max(width * high, max);
            }
            stack.push(curr);
            curr++;
        }
        while (stack.peek() != -1) {
            int high = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            max = Math.max(max, high * width);
        }

        return max;
    }
}
