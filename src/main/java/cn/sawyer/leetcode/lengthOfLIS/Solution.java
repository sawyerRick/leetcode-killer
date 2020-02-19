package cn.sawyer.leetcode.lengthOfLIS;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 最长上升子序列，https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @author: sawyer
 * @create: 2020-02-01 16:36
 **/
public class Solution {


    // dp[i]: nums中 0到i的最长上升子序列
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
