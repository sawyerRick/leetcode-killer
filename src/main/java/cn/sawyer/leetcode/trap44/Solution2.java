package cn.sawyer.leetcode.trap44;

import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 其他解法
 * @author: sawyer
 * @create: 2020-02-22 13:12
 **/

// 单调栈，保持单调递减
public class Solution2 {
    public int trap(int[] height) {

        Stack<Integer> stack = new Stack<>();

        int sum = 0;
        for (int i = 0; i < height.length; i++) {

            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop() ;

                // 无前一个，漏水了
                if (stack.isEmpty()) {
                    break;
                }

                int distance = i - stack.peek() - 1;
                // stack.peek()指前一个
                int h = Math.min(height[stack.peek()], height[i]) - height[top];
                sum += h * distance;

            }
            stack.push(i);
        }


        return sum;
    }
}
