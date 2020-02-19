package cn.sawyer.leetcode.dynamicProgramming.isMatch;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 正则表达式匹配，https://leetcode-cn.com/problems/regular-expression-matching/
 * @author: sawyer
 * @create: 2020-01-25 15:30
 **/

// 通配符和正则区别
// 正则匹配文本，通配符匹配文件名
// 通配符中*任意字符，正则*表示前一个字符重复0/n次
public class Solution10 {

    // 自底向上
    // dp[i][j]: text的前i个和pattern的前j个匹配
    // 遇到*:
    public boolean isMatch3(String text, String pattern) {

        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];





        return true;
    }

    // 备忘录dp
    int[][] memo; // -1:未记录，1:真，0：假
    String text;
    String pattern;

    public boolean isMatch2(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
        this.memo = new int[text.length() + 1][pattern.length() + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return dp(0, 0);
    }

    public boolean dp(int i, int j) {

        if (j == pattern.length()) {
            return i == text.length();
        }

        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }

        boolean ans;

        boolean first_match = (i != text.length() &&
                (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));

        if (j <= pattern.length() - 2 && pattern.charAt(j + 1) == '*') {
            ans = (dp(i, j + 2) ||
                    (first_match && dp(i + 1, j)));
        } else {
            ans = first_match && dp(i + 1, j + 1);
        }

        memo[i][j] = ans ? 1 : 0;
        return ans;
    }

    // 暴力回溯
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }

        // 字符匹配了，或者遇到.了
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        // 精髓
        // pattern长度至少2且遇到*
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            // 两种情况，1：直接忽略pattern的a*部分， 2：text删除*前面的一个字符，继续和pattern比较
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            // 从左到右逐个匹配
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}
