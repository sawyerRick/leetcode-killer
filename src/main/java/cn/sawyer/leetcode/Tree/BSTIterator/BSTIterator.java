package cn.sawyer.leetcode.Tree.BSTIterator;

import cn.sawyer.leetcode.Tree.TreeNode;

import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 二叉搜索树迭代器，https://leetcode-cn.com/problems/binary-search-tree-iterator/
 * @author: sawyer
 * @create: 2020-02-19 21:17
 **/

// 要求空间复杂度为O(h),h为树的高度
public class BSTIterator {

    // 转换成二叉树的迭代中序遍历。

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        push(root);
    }

    private void push(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            push(node.right);
        }
        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}