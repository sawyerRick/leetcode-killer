package cn.sawyer.leetcode.Tree.isSymmetric;

import cn.sawyer.leetcode.Tree.TreeNode;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 对称二叉树，https://leetcode-cn.com/problems/symmetric-tree/
 * @author: sawyer
 * @create: 2020-01-10 14:28
 **/

// 思路：构造一棵镜像的🌲和自己比较
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.remove();
            System.out.println(t1.val);
            TreeNode t2 = q.remove();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}
