package cn.sawyer.leetcode.Tree.flatten;

import cn.sawyer.leetcode.Tree.TreeNode;

/**
 * @program: LeetCode
 * @description: 二叉树原地展开为链表，https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * @author: sawyer
 * @create: 2020-01-10 13:35
 **/

// 要求原地，并且是先序遍历的结果
// 1.将左子树插入到右子树的地方
// 2.将原来的右子树接到左子树的最右边节点
// 3.考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
public class Solution {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode left = root.left;
                // 找左子树最右节点
                while (left.right != null) {
                    left = left.right;
                }

                //将原来的右子树接到左子树的最右边节点
                left.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 下一个节点
                root = root.right;
            }
        }
    }
}
