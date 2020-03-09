package cn.sawyer.contest.contest178.isSubPath;

import cn.sawyer.leetcode.Tree.TreeNode;
import cn.sawyer.leetcode.link.ListNode;

/**
 * @program: LeetCode
 * @description: 二叉树链表，https://leetcode-cn.com/problems/linked-list-in-binary-tree/
 * @author: sawyer
 * @create: 2020-03-01 15:09
 **/
public class Solution {

    boolean dfs(TreeNode root, ListNode head) {

        if (head == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (head.val != root.val) {
            return false;
        }

        return dfs(root.left, head.next) || dfs(root.right, head.next);
    }


    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }

        if (root == null) {
            return false;
        }


        return dfs(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}