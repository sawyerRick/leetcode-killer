package cn.sawyer.leetcodeOffer.validateStackSequences;

import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 栈的压入，弹出序列，https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * @author: sawyer
 * @create: 2020-02-13 15:00
 **/
public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        int i = 0;
        Stack<Integer> stack = new Stack<>();
        for (int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && popped[i] == stack.peek()) {
                stack.pop();
                i++;
            }
        }

        return stack.isEmpty();
    }
}
