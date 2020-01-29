package cn.sawyer.nowcode.twoStackToQueue;

import java.util.Stack;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-01-01 16:08
 **/
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }
}