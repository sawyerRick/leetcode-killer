package cn.sawyer.leetcode.greedy.checkPossibility;

/**
 * @program: LeetCode
 * @description: 非递减数列，https://leetcode-cn.com/problems/non-decreasing-array/
 * @author: sawyer
 * @create: 2020-02-09 14:05
 **/
public class Solution {
    public boolean checkPossibility(int[] nums) {

        boolean check = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] <= nums[i]) {
                continue;
            }

            if (!check) {
                check = true;
                // 整体变大
                if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                    nums[i] = nums[i - 1];
                } else {
                    // 整体变小
                    nums[i - 1] = nums[i];
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
