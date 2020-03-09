package cn.sawyer.leetcode.dynamicProgramming.largestRectangleArea;

import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 柱形图中最大矩形，https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode/
 * @author: sawyer
 * @create: 2020-02-10 14:00
 **/
public class Solution {

    // 解法2：单调栈
    public int largestRectangleArea2(int[] heights) {
        Stack< Integer > stack = new Stack < > ();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; i++) {
            // 维护单调栈，递增
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int high = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxarea = Math.max(maxarea, high * width);
            }
            stack.push(i);
        }
        // 最后递增，处理
        while (stack.peek() != -1) {
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        }
        return maxarea;
    }


    // 解法1：暴力
    public int largestRectangleArea(int[] heights) {

        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = heights[i];
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(heights[j], minHeight);
                ans = Math.max((j - i + 1) * minHeight, ans);
            }
        }

        return ans;
    }
}
