package cn.sawyer.leetcode.findDuplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: LeetCode
 * @description: 寻找重复数，https://leetcode-cn.com/problems/find-the-duplicate-number/
 * @author: sawyer
 * @create: 2020-01-10 15:09
 **/
public class Solution {
    // 排序
    public int findDuplicate(int[] nums) {

        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }

        return -1;
    }

    // set
    public int findDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }


        return 1;
    }
}
