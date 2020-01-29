package cn.sawyer.leetcode.Tree.convertBST;

import cn.sawyer.leetcode.Tree.TreeNode;

/**
 * @program: LeetCode
 * @description: 把二叉搜索树转换成累加树，https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * @author: sawyer
 * @create: 2020-01-22 14:19
 **/
public class Solution {
    int sum;

    void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.right);
        sum += node.val;
        node.val = sum;
        dfs(node.left);
    }

    public TreeNode convertBST(TreeNode root) {
        dfs(root);

        return null;
    }
}
