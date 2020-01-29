package cn.sawyer.leetcode.twoSum;

import java.util.HashMap;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2019-12-17 14:21
 **/
// 两数之和 url:https://leetcode-cn.com/problems/two-sum/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
        }

        return null;
    }
}
