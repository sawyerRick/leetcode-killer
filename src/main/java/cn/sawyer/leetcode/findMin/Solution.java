package cn.sawyer.leetcode.findMin;

/**
 * @program: LeetCode
 * @description: 旋转排序数组中最小值，https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * @author: sawyer
 * @create: 2020-02-27 13:54
 **/
public class Solution {

    // 二分
    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return nums[low];
    }
}