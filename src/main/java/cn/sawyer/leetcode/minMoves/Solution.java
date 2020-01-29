package cn.sawyer.leetcode.minMoves;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 最小移动次数使数组相等，https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/
 * @author: sawyer
 * @create: 2020-01-17 14:46
 **/
public class Solution {
    public int minMoves(int[] nums) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += nums[i] - min;
        }

        return ans;
    }
}
