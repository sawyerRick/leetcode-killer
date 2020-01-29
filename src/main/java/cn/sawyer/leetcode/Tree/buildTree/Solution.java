package cn.sawyer.leetcode.Tree.buildTree;

import cn.sawyer.leetcode.Tree.TreeNode;

/**
 * @program: LeetCode
 * @description: 从前序遍历和中序遍历构造二叉树，https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @author: sawyer
 * @create: 2020-01-19 15:33
 **/
public class Solution {
    int[] inorder;

    // 反向dfs
    TreeNode rdfs(int i) {

        TreeNode node = new TreeNode(inorder[i]);

        node.left = rdfs(i + 1);
        node.right = rdfs(i + 2);

        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;

        TreeNode root = new TreeNode(inorder[0]);
        rdfs(0);


        return root;
    }
}
