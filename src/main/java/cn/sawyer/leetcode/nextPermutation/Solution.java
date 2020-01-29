package cn.sawyer.leetcode.nextPermutation;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 下一个排列，https://leetcode-cn.com/problems/next-permutation/
 * @author: sawyer
 * @create: 2020-01-17 13:44
 **/
public class Solution {
    // 思路1：暴力，找出nums的全排列，按顺序找出下一个
    // 思路2：从右到左遍历
    // 找到 第一个nums[i] > nums[i - 1]
    // 找不到就排序，返回
    // 找到后 排序i~len，从i开始（包括i）找出第一个大于nums[i - 1]的，交换
    public void nextPermutation(int[] nums) {

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == 0) {
                Arrays.sort(nums);
                return ;
            }
            if (nums[i] > nums[i - 1]) {
                Arrays.sort(nums, i, nums.length);
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > nums[i - 1]) {
                        int tmp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = tmp;
                        return;
                    }
                }
            }
        }
    }
}
