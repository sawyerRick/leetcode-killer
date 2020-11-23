package interview.mihayou;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-13 18:50
 **/
import java.util.*;


public class Solution {
    /**
     *
     * @param s string字符串
     * @return string字符串
     */
    public String minRemove (String s) {
        // write code here

        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c + "");
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    StringBuilder sub = new StringBuilder();
                    sub.append("(");
                    while (!stack.isEmpty()) {
                        String p = stack.pop();
                        sub.append(p);
                        if (p.equals("(")) {
                            break;
                        }
                    }
                    sub.append(")");
                    sb.append(sub.toString());
                }
            } else {
                stack.push("" + c);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.minRemove("a(b(");
        System.out.println(s);
    }
}