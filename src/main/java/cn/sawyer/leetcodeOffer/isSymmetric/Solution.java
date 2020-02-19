package cn.sawyer.leetcodeOffer.isSymmetric;

import cn.sawyer.leetcode.Tree.TreeNode;

/**
 * @program: LeetCode
 * @description: 判断二叉树对称，https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * @author: sawyer
 * @create: 2020-02-15 15:13
 **/
class Solution {

    boolean ans = true;
    void dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null || !ans) {
            return;
        }
        if (root1 == null || root2 == null) {
            ans = false;
            return;
        }

        if (root1.val != root2.val) {
            ans = false;
            return;
        }
        dfs(root1.left, root2.right);
        dfs(root1.right, root2.left);
    }

    public boolean isSymmetric(TreeNode root) {

        dfs(root, root);

        return ans;
    }
}