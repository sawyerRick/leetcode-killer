package cn.sawyer.leetcode.longestValidParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 再写
 * @author: sawyer
 * @create: 2020-03-15 18:45
 **/

public class Solution2 {

    // 下标入栈
    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // 垫底
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else  {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i); // i 为底
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }
}