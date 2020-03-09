package cn.sawyer.leetcode.sortArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 排序，https://leetcode-cn.com/problems/sort-an-array/
 * @author: sawyer
 * @create: 2020-02-23 15:06
 **/
public class Solution {
    public List<Integer> sortArray(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        // 插入排序

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        return list;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
