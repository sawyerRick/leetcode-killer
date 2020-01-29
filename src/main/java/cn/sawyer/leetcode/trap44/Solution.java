package cn.sawyer.leetcode.trap44;

/**
 * @program: LeetCode
 * @description: 接雨水，url:https://leetcode-cn.com/problems/trapping-rain-water/
 * @author: sawyer
 * @create: 2019-12-30 13:24
 **/
public class Solution {
    // 暴力法，对于数组中的每个元素，找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
    public int trap(int[] height) {
        int ans = 0;

        for (int i = 1; i < height.length; i++) {
            int maxLeft = height[i];
            // 找左边最大值
            for (int j = i; j >= 0 ; j--) {
                maxLeft = Math.max(height[j], maxLeft);
            }

            int maxRight = height[i];
            // 找右边最大值
            for (int j = i; j < height.length; j++) {
                maxRight = Math.max(height[j], maxRight);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];
        }


        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
