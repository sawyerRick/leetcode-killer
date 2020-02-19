package cn.sawyer.leetcode.missingNumber;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 缺失数字
 * @author: sawyer
 * @create: 2020-02-07 18:30
 **/
public class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

}