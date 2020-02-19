package cn.sawyer.leetcode.dynamicProgramming.isMatch;


/**
 * @program: LeetCode
 * @description: 通配符匹配，https://leetcode-cn.com/problems/wildcard-matching/submissions/
 * @author: sawyer
 * @create: 2020-02-02 14:35
 **/
public class Solution44 {

    // dp[i][j]:表示s的前i个和p的前i个匹配
    // 状态转移方程：
    // 遇到*: dp[i][j] = dp[i - 1][j] || dp[i][j - 1]
    // 初始化
    public boolean isMatchDp(String s, String p) {

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        // init
        for (int i = 1; i <= p.length(); i++) {
            dp[0][i] = (p.charAt(i - 1) == '*') && dp[0][i - 1];
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    // 回溯 有错误
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        boolean firstMatch;
        if (!s.isEmpty()) {
            if (p.charAt(0) == '*') {
                firstMatch = true;
            } else {
                firstMatch = s.charAt(0) == p.charAt(0) || p.charAt(0) == '?';
            }
        } else {
            firstMatch = p.charAt(0) == '*';
        }

        if (p.charAt(0) == '*') {
            return firstMatch && (isMatch(s, p.substring(1)) || isMatch(s.substring(1), p));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        Solution44 solution = new Solution44();
        boolean a = solution.isMatch("a", "**");
        System.out.println(a);
    }
}
