package cn.sawyer.leetcode.Tree.lowestCommonAncestor;

import cn.sawyer.leetcode.Tree.TreeNode;

/**
 * @program: LeetCode
 * @description: 最近公共祖先，https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * @author: sawyer
 * @create: 2020-02-17 14:45
 **/
public class Solution {

    TreeNode p;
    TreeNode q;
    TreeNode ans;

    boolean dfs(TreeNode node) {
        if (node == null || ans != null) {
            return false;
        }

        boolean left = dfs(node.left);
        boolean right = dfs(node.right);
        boolean curr = p == node || q == node;
        if ((left && right)
                || (left && curr)
                || (right && curr)) {
            ans = node;
        }

        return curr || left || right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        dfs(root);

        return ans;
    }
}
