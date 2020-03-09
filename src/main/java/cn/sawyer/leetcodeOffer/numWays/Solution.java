package cn.sawyer.leetcodeOffer.numWays;

/**
 * @program: LeetCode
 * @description: 青蛙跳台阶，https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * @author: sawyer
 * @create: 2020-02-27 11:56
 **/
public class Solution {
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }


        return dp[n];
    }
}