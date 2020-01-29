package cn.sawyer.leetcode.dynamicProgramming.maxSubArray;

/**
 * @program: LeetCode
 * @description: 最大子序和，https://leetcode-cn.com/problems/maximum-subarray/
 * @author: sawyer
 * @create: 2020-01-16 21:49
 **/
public class Solution {
    public int maxSubArray(int[] nums) {
        // 连加，当出现负数，从下一个开始。

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);
            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}
