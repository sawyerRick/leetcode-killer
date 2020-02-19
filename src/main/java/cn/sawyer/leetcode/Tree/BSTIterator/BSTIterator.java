package cn.sawyer.leetcode.Tree.BSTIterator;

import cn.sawyer.leetcode.Tree.TreeNode;

/**
 * @program: LeetCode
 * @description: 二叉搜索树迭代器，https://leetcode-cn.com/problems/binary-search-tree-iterator/
 * @author: sawyer
 * @create: 2020-02-19 21:17
 **/

// 要求空间复杂度为O(h),h为树的高度
public class BSTIterator {

    public BSTIterator(TreeNode root) {

    }

    /** @return the next smallest number */
    public int next() {
        return 1;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return true;
    }
}