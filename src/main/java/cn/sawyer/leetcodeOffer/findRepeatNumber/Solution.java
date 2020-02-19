package cn.sawyer.leetcodeOffer.findRepeatNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: LeetCode
 * @description: 找出重复元素，https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @author: sawyer
 * @create: 2020-02-12 19:21
 **/
public class Solution {
    public int findRepeatNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return i;
            }
            set.add(i);
        }

        return nums[0];
    }
}
