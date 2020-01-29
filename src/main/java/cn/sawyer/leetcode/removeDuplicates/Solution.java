package cn.sawyer.leetcode.removeDuplicates;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2019-12-17 16:43
 **/
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 1, 1, 1, 2, 2, 2};
        int i = solution.removeDuplicates(nums);
        System.out.println(i);
//        for (int j = 0; j < i; j++) {
//            System.out.println(nums[j]);
//        }
    }
}