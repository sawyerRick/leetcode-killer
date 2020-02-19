package cn.sawyer.leetcodeOffer.twoSum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: LeetCode
 * @description: 和为s的两个数字，https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * @author: sawyer
 * @create: 2020-02-12 21:10
 **/
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            if (map.containsKey(t)) {
                return new int[]{nums[i], nums[map.get(t)]};
            }
        }

        return null;
    }
}
