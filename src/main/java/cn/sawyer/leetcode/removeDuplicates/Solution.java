package cn.sawyer.leetcode.removeDuplicates;

/**
 * @program: LeetCode
 * @description: 删除排序数组重复项，https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * @author: sawyer
 * @create: 2019-12-17 16:43
 **/

// 双指针
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}