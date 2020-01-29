package cn.sawyer.leetcode.Tree.invertTree;

import cn.sawyer.leetcode.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 翻转二叉树，https://leetcode-cn.com/problems/invert-binary-tree/
 * @author: sawyer
 * @create: 2020-01-29 17:23
 **/
public class Solution {

    // bfs
    public TreeNode invertTree2(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr != null) {
                TreeNode tmp = curr.left;
                curr.left = curr.right;
                curr.right = tmp;

                queue.add(curr.left);
                queue.add(curr.right);
            }
        }

        return root;
    }


    // dfs
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
