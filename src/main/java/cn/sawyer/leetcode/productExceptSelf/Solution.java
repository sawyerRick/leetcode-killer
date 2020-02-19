package cn.sawyer.leetcode.productExceptSelf;

/**
 * @program: LeetCode
 * @description: 除自身以外的乘积，https://leetcode-cn.com/problems/product-of-array-except-self/
 * @author: sawyer
 * @create: 2020-02-16 15:34
 **/

// 左右乘积列表
public class Solution {

    public int[] productExceptSelf(int[] nums) {

        int[] left = new int[nums.length]; // left[i]表示nums[i]左边的乘积
        int[] right = new int[nums.length];
        int[] ans = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[right.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;
    }
}
