package cn.sawyer.leetcodeOffer.maxSubArray;

/**
 * @program: LeetCode
 * @description: 连续子数组最大和，https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * @author: sawyer
 * @create: 2020-02-28 16:51
 **/
public class Solution {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.println(sum);
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}