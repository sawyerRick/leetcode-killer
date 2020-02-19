package cn.sawyer.mianshibaodian.oneEditAway;

/**
 * @program: LeetCode
 * @description: 一次编辑，https://leetcode-cn.com/problems/one-away-lcci/
 * @author: sawyer
 * @create: 2020-02-18 13:07
 **/

// 解法，参考编辑距离，dp
public class Solution {


    public boolean oneEditAway(String first, String second) {

        // 下标从1开始，0作为空串

        int[][] dp = new int[first.length() + 1][second.length() + 1];
        dp[0][0] = 0;
        // init
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }

        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }

        for (int i = 1; i < first.length() + 1; i++) {
            for (int j = 1; j < second.length() + 1; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }

        return dp[first.length()][second.length()] == 1 || dp[first.length()][second.length()] == 0;
    }
}