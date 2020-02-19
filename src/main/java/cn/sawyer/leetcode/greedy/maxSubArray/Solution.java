package cn.sawyer.leetcode.greedy.maxSubArray;

/**
 * @program: LeetCode
 * @description: 最大自序和，https://leetcode-cn.com/problems/maximum-subarray/
 * @author: sawyer
 * @create: 2020-02-09 14:33
 **/
public class Solution {
    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}
