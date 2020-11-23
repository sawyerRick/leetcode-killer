package cn.sawyer.leetcode.dynamicProgramming.lengthOfLIS;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 最长上升子序列，https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @author: sawyer
 * @create: 2020-03-15 19:04
 **/
public class Solution {

    // dp[i]：在i个字符结尾的序列最长长度
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

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
            max = Math.max(dp[i], max);
        }

        return max;
    }
}