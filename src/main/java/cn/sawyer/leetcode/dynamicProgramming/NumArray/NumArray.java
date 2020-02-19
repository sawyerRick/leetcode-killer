package cn.sawyer.leetcode.dynamicProgramming.NumArray;

/**
 * @program: LeetCode
 * @description: 区域和检索，https://leetcode-cn.com/problems/range-sum-query-immutable/
 * @author: sawyer
 * @create: 2020-02-19 20:01
 **/
class NumArray {

    // 前缀和
    // sum(i, j) = dp[j] - dp[i]
    int[] dp;

    public NumArray(int[] nums) {
        dp = new int[nums.length + 1];
        dp[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = dp[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {

        return dp[j + 1] - dp[i];
    }
}

