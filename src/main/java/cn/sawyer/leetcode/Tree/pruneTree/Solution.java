package cn.sawyer.leetcode.Tree.pruneTree;

import cn.sawyer.leetcode.Tree.TreeNode;

/**
 * @program: LeetCode
 * @description: 二叉树剪枝
 * @author: sawyer
 * @create: 2020-02-08 15:52
 **/
public class Solution {

    // dfs 后序遍历
    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        root.left = left == 0? null : root.left;
        root.right = right == 0? null : root.right;
        return left + right + root.val;
    }

    public TreeNode pruneTree(TreeNode root) {
        dfs(root);

        return root;
    }
}
