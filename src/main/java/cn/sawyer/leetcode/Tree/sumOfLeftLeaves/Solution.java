package cn.sawyer.leetcode.Tree.sumOfLeftLeaves;

import cn.sawyer.leetcode.Tree.TreeNode;

/**
 * @program: LeetCode
 * @description: 二叉树所有左子叶之和
 * @author: sawyer
 * @create: 2020-02-19 13:54
 **/
public class Solution {

    int sum;

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        dfs(root.left);
        dfs(root.right);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);

        return sum;
    }
}
