package cn.sawyer.leetcodeOffer.minArray;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-27 13:44
 **/
public class Solution {

    // 二分
    public int minArray(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high--;
            }
        }

        return nums[low];
    }
}