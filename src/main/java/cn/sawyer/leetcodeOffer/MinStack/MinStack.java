package cn.sawyer.leetcodeOffer.MinStack;

import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 最小栈，https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * @author: sawyer
 * @create: 2020-02-15 15:04
 **/
public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> helper = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (helper.isEmpty() || x < helper.peek()) {
            helper.push(x);
        } else {
            helper.push(helper.peek());
        }
    }

    public void pop() {
        stack.pop();
        helper.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public int min() {
        return helper.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
