package cn.sawyer.contest.contest178.smallerNumbersThanCurrent;

/**
 * @program: LeetCode
 * @description: 有多少小于当前数字的数字。https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * @author: sawyer
 * @create: 2020-03-01 13:05
 **/
public class Solution {

    // 暴力
    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[j] < nums[i]) {
                    ans[i]++;
                }
            }
        }

        return ans;
    }
}