package cn.sawyer.leetcode.isValid;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-22 13:01
 **/
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !map.get(stack.peek()).equals(c)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.size() == 0;
    }

}