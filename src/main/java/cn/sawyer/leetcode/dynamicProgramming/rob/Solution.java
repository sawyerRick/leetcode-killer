package cn.sawyer.leetcode.dynamicProgramming.rob;

import cn.sawyer.leetcode.Tree.TreeNode;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 打家劫舍1 2 3
 * https://leetcode-cn.com/problems/house-robber/
 * https://leetcode-cn.com/problems/house-robber-ii/
 * https://leetcode-cn.com/problems/house-robber-iii/
 * @author: sawyer
 * @create: 2020-01-07 15:30
 **/
public class Solution {

    // 1  dp数组解法
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        // dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }
    // 1 前驱节点写法
    public int rob1(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }

    // 2 房屋都围成一圈 (从第一个开始，或者第二个开始)
    public int rob2(int[] nums) {

        // i != len - 1 : dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }


        return Math.max(robRange(nums, 0, nums.length - 2),
                robRange(nums, 1, nums.length - 1));
    }

    public int robRange(int[] nums, int start, int end) {
        int dp_i = 0;
        int dp_i_1 = 0; // i - 1
        int dp_i_2 = 0; // i - 2


        for (int i = start; i < end; i++) {
            dp_i = Math.max(dp_i_2 + nums[i], dp_i_1);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }

        return dp_i;
    }

    // 3 层次遍历，从0层开始打劫，从1层开始打劫
    // 3 Dfs 回溯
    // 备忘录
    Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob3(TreeNode root) {
        if (root == null) return 0;
        // 利用备忘录消除重叠子问题
        if (memo.containsKey(root))
            return memo.get(root);
        // 抢，然后去下下家
        int do_it = root.val +
                (root.left == null ? 0 : rob3(root.left.left) + rob3(root.left.right))
                +
                (root.right == null ? 0 : rob3(root.right.left) + rob3(root.right.right));
        // 不抢，然后去下家
        int not_do = rob3(root.left) + rob3(root.right);

        int res = Math.max(do_it, not_do);
        memo.put(root, res);
        return res;
    }
}
