package cn.sawyer.leetcode.Tree.diameterOfBinaryTree;

import cn.sawyer.leetcode.Tree.TreeNode;

/**
 * @program: LeetCode
 * @description: 二叉树的直径，https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * @author: sawyer
 * @create: 2020-01-20 16:39
 **/
public class Solution {
    int ans;

    // 后序遍历，左右子树深度之和

    int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);
        ans = Math.max(ans, left + right + 1);

        return Math.max(right, left) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {

        dfs(root);

        return ans;
    }
}
