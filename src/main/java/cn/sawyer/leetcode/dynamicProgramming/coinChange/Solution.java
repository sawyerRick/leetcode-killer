package cn.sawyer.leetcode.dynamicProgramming.coinChange;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 零钱兑换，https://leetcode-cn.com/problems/coin-change/
 * @author: sawyer
 * @create: 2020-01-12 13:49
 **/
public class Solution {

    // 暴力递归，超时
    public int coinChange2(int[] coins, int amount) {
        List list = new ArrayList();
        if (amount == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int c : coins) {
            if (c <= amount) {
                int subProb = coinChange(coins, amount - c);
                // 子问题不可达
                if (subProb != -1) {
                    min = Math.min(min, subProb) + 1;
                }
            }
        }

        return min == Integer.MAX_VALUE? -1: min;
    }

    // 备忘录递归，自顶向下
    Map<Integer, Integer> memo = new HashMap<>();
    public int coinChange3(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int min = Integer.MAX_VALUE;
        for (int c : coins) {
            if (c <= amount) {
                int subProb = coinChange(coins, amount - c);
                // 子问题可达
                if (subProb != -1) {
                    min = Math.min(min, subProb + 1);
                }
            }
        }

        memo.put(amount, min == Integer.MAX_VALUE? -1: min);
        return min == Integer.MAX_VALUE? -1: min;
    }


    // dp
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // dp[i]: amount为i的时候的最少硬币数量
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (c <= i) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                    System.out.println(dp[i]);
                }
            }
        }

        return dp[amount] > amount? -1: dp[amount];
    }
}
