package cn.sawyer.leetcode.maxSlidingWindow;

/**
 * @program: LeetCode
 * @description: 滑动窗口最大值，https://leetcode-cn.com/problems/sliding-window-maximum/
 * @author: sawyer
 * @create: 2020-01-10 15:44
 **/
public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        System.out.println(dp[0]);

        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
            System.out.println(dp[i]);
        }

        int[] ans = new int[nums.length - k];
        System.out.println("size:" + ans.length);
        ans[0] = dp[k - 1];

        // 从k后一个开始
        for (int i = k; i < nums.length; i++) {
            int left = i - (k - 1);
            System.out.println("left = " + dp[left - 1]);
            System.out.println("right = " + dp[i]);
            ans[left] = dp[i] - dp[left - 1];
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxSlidingWindow(new int[] {1, 2, 3, 4, 5}, 2);
    }
}
