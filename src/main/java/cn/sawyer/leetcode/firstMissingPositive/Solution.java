package cn.sawyer.leetcode.firstMissingPositive;

import org.omg.CORBA.INTERNAL;

/**
 * @program: LeetCode
 * @description: 缺失的第一个正数，https://leetcode-cn.com/problems/first-missing-positive/
 * @author: sawyer
 * @create: 2020-02-03 16:37
 **/
class Solution {
    // 桶排序
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            // nums[nums[i] - 1] != nums[i]: 当前位置不正确
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // 满足在指定范围内、并且没有放在正确的位置上，才交换
                // 例如：数值 3 应该放在索引 2 的位置上
                swap(nums, nums[i] - 1, i);
            }
        }

        // [1, -1, 3, 4]
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}