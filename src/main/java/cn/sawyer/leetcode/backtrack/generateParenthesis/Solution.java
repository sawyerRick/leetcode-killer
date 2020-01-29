package cn.sawyer.leetcode.backtrack.generateParenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 括号生成 url:https://leetcode-cn.com/problems/generate-parentheses/submissions/
 * @author: sawyer
 * @create: 2019-12-27 19:38
 **/

// 回溯法
public class Solution {
    List<String> res = new ArrayList<>();
    int n;


    public void backtrack(String curr, int open, int close) {
        if (n * 2 == curr.length()) {
            res.add(curr);
            return;
        }

        if (open < n) {
            backtrack(curr + "(", open + 1, close);
        }

        if (close < open) {
            backtrack(curr + ")", open, close + 1);
        }

    }

    public List<String> generateParenthesis(int n) {
        this.n = n;
        backtrack("", 0, 0);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (String generateParenthesis : solution.generateParenthesis(4)) {
            System.out.println(generateParenthesis);
        }
    }

}
