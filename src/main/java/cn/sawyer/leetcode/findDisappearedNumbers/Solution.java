package cn.sawyer.leetcode.findDisappearedNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 找到数组中消失的数字，https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 * @author: sawyer
 * @create: 2020-02-17 14:16
 **/
public class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;

            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
