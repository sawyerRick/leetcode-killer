package cn.sawyer.leetcode.dynamicProgramming.minCostClimbingStairs;

/**
 * @program: LeetCode
 * @description: 最小花费爬楼梯，https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * @author: sawyer
 * @create: 2020-01-28 14:23
 **/
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int i = solution.minCostClimbingStairs(new int[]{1, 2, 3, 4});
        System.out.println(i);
    }
}
