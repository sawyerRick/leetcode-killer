package cn.sawyer.leetcodeOffer;

import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 两个栈实现队列
 * @author: sawyer
 * @create: 2020-02-27 11:48
 **/
public class CQueue {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> helper = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        stack.push(value);
    }

    // 优化
    public int deleteHead() {
        if (stack.isEmpty() && helper.isEmpty())
            return -1;
        if (helper.isEmpty()){
            while (!stack.isEmpty()) {
                helper.push(stack.pop());
            }
        }
        return helper.pop();
    }

//    public int deleteHead() {
//        while (stack.size() > 1) {
//            helper.push(stack.pop());
//        }
//        int ans = -1;
//        if (stack.size() == 1) {
//            ans = stack.pop();
//        }
//        while (helper.size() > 0) {
//            stack.push(helper.pop());
//        }
//
//        return ans;
//    }
}