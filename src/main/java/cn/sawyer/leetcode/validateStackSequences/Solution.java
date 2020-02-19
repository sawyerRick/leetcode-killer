package cn.sawyer.leetcode.validateStackSequences;

import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 验证栈序列，https://leetcode-cn.com/problems/validate-stack-sequences/
 * @author: sawyer
 * @create: 2020-02-13 15:02
 **/
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        // 贪心，入栈，peek相等出栈。
        Stack<Integer> stack = new Stack<>();
        int p = 0;

        for (int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && p < pushed.length && stack.peek() == popped[p]) {
                stack.pop();
                p++;
            }
        }

        return stack.isEmpty();
    }
}