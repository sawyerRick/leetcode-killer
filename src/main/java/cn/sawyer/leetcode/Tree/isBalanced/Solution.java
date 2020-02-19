package cn.sawyer.leetcode.Tree.isBalanced;

import cn.sawyer.leetcode.Tree.TreeNode;

/**
 * @program: LeetCode
 * @description: 判断平衡二叉树，https://leetcode-cn.com/problems/balanced-binary-tree/
 * @author: sawyer
 * @create: 2020-02-04 23:10
 **/
class Solution {
    boolean ans = true;

    // dfs后序遍历
    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (ans) {
            int l = dfs(root.left);
            int r = dfs(root.right);

            if (Math.abs(l - r) > 1) {
                ans = false;
            }
            return Math.max(l, r) + 1;
        } else {
            return 0;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        dfs(root);

        return ans;
    }
}