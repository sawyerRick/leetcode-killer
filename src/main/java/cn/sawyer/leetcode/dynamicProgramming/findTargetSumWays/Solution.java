package cn.sawyer.leetcode.dynamicProgramming.findTargetSumWays;

/**
 * @program: LeetCode
 * @description: 目标和，https://leetcode-cn.com/problems/target-sum/solution/mu-biao-he-by-leetcode/
 * @author: sawyer
 * @create: 2020-02-03 14:41
 **/
public class Solution {

    // dp
    public int findTargetSumWays2(int[] nums, int S) {



        return 1;
    }

    // 暴力回溯
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }

    public void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S) {
                count++;
            }
        } else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }
}
