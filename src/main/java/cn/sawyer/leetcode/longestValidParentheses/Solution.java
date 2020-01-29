package cn.sawyer.leetcode.longestValidParentheses;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 最长有效括号，https://leetcode-cn.com/problems/longest-valid-parentheses/
 * @author: sawyer
 * @create: 2020-01-24 15:15
 **/
public class Solution {
    // 思路，用栈找出对应序号，排序，找最长连续序列长度。
    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        List<Integer> pos = new ArrayList<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (!stack.isEmpty()){

                pos.add(i);
                pos.add(stack.pop());
            }
        }

        Collections.sort(pos);
        int max = 0;
        int count = 1;
        for (int i = 1; i < pos.size(); i++) {
            if (pos.get(i).equals(pos.get(i - 1) + 1)) {
                count++;
            } else {
                count = 1;
            }
            max = Math.max(count, max);
        }

        return max;
    }

    // 思路2，不用排序，在栈中解决
    public int longestValidParentheses2(String s) {

        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(-1);

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

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestValidParentheses("(()");
    }
}
