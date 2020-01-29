package cn.sawyer.leetcode.searchRange;

/**
 * @program: LeetCode
 * @description: 在有序表中查找元素首次和最后出现的位置，url:https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @author: sawyer
 * @create: 2020-01-04 13:11
 **/
public class Solution {
    // 时间复杂度O(n)
    public int[] searchRange(int[] nums, int target) {

        int first = 0;
        boolean f = false;
        int last = 0;
        boolean l = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && !f) {
                first = i;
                f = true;
            }

            if (nums[i] == target && i >= last) {
                last = i;
                l = true;
            }
        }

        return new int[]{f ? first : -1, l ? last : -1};
    }

    // 时间复杂度O(log2N)
    // 二分查找
    public int[] searchRange2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = nums.length / 2;

        int[] ans = new int[]{-1, -1};

        while (low < high) {

            if (target == nums[mid]) {
                // find last
                int i = mid;
                if (nums[nums.length - 1] == target) {
                    ans[1] = nums.length - 1;
                } else {
                    while (target == nums[++i]) {
                    }
                    ans[1] = i - 1;
                }

                // find first
                if (nums[0] == target) {
                    ans[0] = 0;
                } else {
                    i = mid;
                    while (target == nums[--i]) {
                    }
                    ans[0] = i + 1;
                }
                break;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = (high + low) / 2;
        }


        return ans;
    }
}
