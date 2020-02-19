package cn.sawyer.leetcode.MyStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-05 00:54
 **/
public class MyStack2 {
    Queue<Integer> queue;
    int top;

    /** Initialize your data structure here. */
    public MyStack2() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = queue.size();
        while (size-- > 1) {
            top = queue.remove();
            queue.add(top);
        }
        return queue.isEmpty()? 0: queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
