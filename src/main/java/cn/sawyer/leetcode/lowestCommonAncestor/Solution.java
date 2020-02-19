package cn.sawyer.leetcode.lowestCommonAncestor;

import cn.sawyer.leetcode.Tree.TreeNode;

/**
 * @program: LeetCode
 * @description: 二叉树的最近公共祖先，https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @author: sawyer
 * @create: 2020-02-16 15:38
 **/
public class Solution {
    TreeNode p;
    TreeNode q;

    TreeNode ans;

    boolean dfs(TreeNode node) {
        if (node == null || ans != null) {
            return false;
        }
        boolean curr = node == q || node == p;
        boolean left = dfs(node.left);
        boolean right = dfs(node.right);
        if ((left && right)
                || (left && curr)
                || (right && curr)) {
            ans = node;
        }

        return left || right || curr;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        this.p = p;
        this.q = q;
        dfs(root);

        return ans;
    }
}
