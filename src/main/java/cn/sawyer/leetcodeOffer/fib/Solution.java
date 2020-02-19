package cn.sawyer.leetcodeOffer.fib;

/**
 * @program: LeetCode
 * @description: 斐波那契数列，https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/submissions/
 * @author: sawyer
 * @create: 2020-02-13 12:22
 **/
class Solution {


    // dp
    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n] % 1000000007;
    }

    // 暴力解法
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }
}
