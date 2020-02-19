package cn.sawyer.leetcode.evalRPN;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 逆波兰式，https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * @author: sawyer
 * @create: 2020-02-01 16:00
 **/
public class Solution {

    // switch
    public int evalRPN2(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer op1, op2;

        for (String s : tokens) {
            switch (s) {
                case "+":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 + op2);
                    break;
                case "-":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 - op2);
                    break;
                case "/":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 / op2);
                    break;
                case "*":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 * op2);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }

        }

        return stack.peek();
    }


    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        set.add('*');
        set.add('-');
        set.add('+');
        set.add('/');

        for (int i = 0; i < tokens.length; i++) {
            System.out.println(stack.size());
            char c = tokens[i].length() == 1?tokens[i].charAt(0): '.';
            if (set.contains(c)) {
                int back = stack.pop();
                int front = stack.pop();

                if (c == '*') {
                    stack.push(back * front);
                } else if (c == '/') {
                    stack.push(front / back);
                } else if (c == '+') {
                    stack.push(front + back);
                } else if (c == '-') {
                    stack.push(front - back);
                }
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.peek();
    }
}
