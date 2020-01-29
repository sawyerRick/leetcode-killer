package cn.sawyer.leetcode.findPeakElement;

/**
 * @program: LeetCode
 * @description: 寻找峰值，https://leetcode-cn.com/problems/find-peak-element/
 * @author: sawyer
 * @create: 2020-01-20 18:18
 **/
public class Solution {

    // 要求O(logN) 二分查找 二叉搜索树
    public int findPeakElement(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            if (i == nums.length - 1) {
                if (nums[i] > nums[i - 1]) {
                    return i;
                }
            } else if (nums[i] > nums[i + 1] && nums[i] > nums[i - 1]) {
                return i;
            }
        }

        return 0;
    }
}
