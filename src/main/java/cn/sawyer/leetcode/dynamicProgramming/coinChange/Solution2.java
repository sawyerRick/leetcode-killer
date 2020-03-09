package cn.sawyer.leetcode.dynamicProgramming.coinChange;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-08 14:01
 **/

// 刷
public class Solution2 {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {

            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    min = Math.min(dp[i - coins[j]], min);
                }
            }
            System.out.println("i = " + i);
            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }
        }
        for (int i : dp) {
            System.out.println(i);
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.coinChange(new int[]{2}, 3);
    }
}
