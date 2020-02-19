package cn.sawyer.leetcode.Tree.maxPathSum;

import cn.sawyer.leetcode.Tree.TreeNode;

/**
 * @program: LeetCode
 * @description: 最大路径和，https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * @author: sawyer
 * @create: 2020-02-17 16:07
 **/
public class Solution {
    int max = Integer.MIN_VALUE;

    public int dfs(TreeNode node) {
        if (node == null) return 0;

        // 后序遍历，获得非负数
        int left = Math.max(dfs(node.left), 0);
        int right = Math.max(dfs(node.right), 0);


        // 更新最大值
        max = Math.max(max, node.val + left + right);

        return node.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
}