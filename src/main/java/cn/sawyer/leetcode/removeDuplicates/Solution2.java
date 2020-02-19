package cn.sawyer.leetcode.removeDuplicates;

/**
 * @program: LeetCode
 * @description: 删除排序数组中重复项2，https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * @author: sawyer
 * @create: 2020-02-19 14:49
 **/


// 要求可以保留两个重复。 双指针+count
public class Solution2 {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n != nums[i-2])
                nums[i++] = n;
        return i;
    }
}