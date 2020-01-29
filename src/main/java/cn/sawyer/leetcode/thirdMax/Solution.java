package cn.sawyer.leetcode.thirdMax;

/**
 * @program: LeetCode
 * @description: 第三大的数，https://leetcode-cn.com/problems/third-maximum-number/
 * @author: sawyer
 * @create: 2020-01-26 14:42
 **/
public class Solution {

    public int thirdMax(int[] nums) {

        int first = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (first <= nums[i]) {
                first = nums[i];
            }
        }

        int second = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (second <= nums[i] && nums[i] != first) {
                second = nums[i];
            }
        }

        boolean find = false;
        int third = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (third <= nums[i] && nums[i] != second && nums[i] != first) {
                third = nums[i];
                find = true;
            }
        }

        if (!find) {
            return first;
        } else {
            return third;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.thirdMax(new int[] {1, 2, Integer.MIN_VALUE}));
    }
}
