package cn.sawyer.leetcodeOffer.checkSubTree;

import cn.sawyer.leetcode.Tree.TreeNode;

/**
 * @program: LeetCode
 * @description: 检查子树，https://leetcode-cn.com/problems/check-subtree-lcci/
 * @author: sawyer
 * @create: 2020-03-01 15:45
 **/
public class Solution {

    boolean dfs(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return true;
        }

        if (t2 == null || t1 == null) {
            return false;
        }

        if (t1.val != t2.val) {
            return false;
        }


        return dfs(t1.left, t2.left) || dfs(t1.left, t2.left);
    }


    public boolean checkSubTree(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return true;
        }

        if (t2 == null || t1 == null) {
            return false;
        }


        return dfs(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }
}