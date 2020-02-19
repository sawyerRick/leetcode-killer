package cn.sawyer.leetcodeOffer.mirrorTree;

import cn.sawyer.leetcode.Tree.TreeNode;

/**
 * @program: LeetCode
 * @description: 二叉树的镜像，https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * @author: sawyer
 * @create: 2020-02-15 15:10
 **/
public class Solution {

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        dfs(root.left);
        dfs(root.right);
    }

    public TreeNode mirrorTree(TreeNode root) {

        dfs(root);

        return root;
    }
}
