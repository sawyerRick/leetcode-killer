package cn.sawyer.leetcode.search;

/**
 * @program: LeetCode
 * @description: 再写一次
 * @author: sawyer
 * @create: 2020-02-27 14:03
 **/
public class Solution2 {

    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }

    int helper(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            return Math.max(helper(nums, target, left, mid - 1), helper(nums, target, mid + 1, right));
        }
        return -1;
    }
}
