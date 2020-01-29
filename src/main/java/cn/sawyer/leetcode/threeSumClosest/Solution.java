package cn.sawyer.leetcode.threeSumClosest;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2019-12-17 14:07
 **/
// 最接近的三数之和
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int tmp = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - tmp) < Math.abs(target - closest)) {
                    closest = tmp;
                }

                if (tmp > target) {
                    r--;
                } else if (tmp < target) {
                    l++;
                } else {
                    return target;
                }
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int r = solution.threeSumClosest(new int[]{1, 2, 3, 5, 7, 9}, 100);
        System.out.println("r = " + r);
    }
}