package cn.sawyer.leetcodeOffer.isStraight;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 扑克牌中的顺子，https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 * @author: sawyer
 * @create: 2020-02-15 17:37
 **/
public class Solution {

    public boolean isStraight(int[] nums) {

        Arrays.sort(nums);
        int zero = 0;
        int needZero = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                zero++;
            } else {
                if (nums[i] == nums[i + 1]) {
                    return false;
                }
                needZero += nums[i + 1] - nums[i] - 1;
            }
        }

        return zero >= needZero;
    }
}
