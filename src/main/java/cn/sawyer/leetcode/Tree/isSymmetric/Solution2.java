package cn.sawyer.leetcode.Tree.isSymmetric;

import cn.sawyer.leetcode.Tree.TreeNode;

/**
 * @program: LeetCode
 * @description: 判断对称二叉树，https://leetcode-cn.com/problems/symmetric-tree/
 * @author: sawyer
 * @create: 2020-02-04 23:32
 **/
public class Solution2 {
    boolean ans = true;

    // 双重递归
    // 前序遍历
    void doubleDfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return;
        } else if (root1 == null || root2 == null || !ans) {
            ans = false;
            return;
        }

        int curr1 = root1.val;
        int curr2 = root2.val;
        if (curr1 != curr2) {
            ans = false;
            return;
        }
        doubleDfs(root1.left, root2.right);
        doubleDfs(root2.left, root1.right);
    }

    // 再写一遍
    public boolean isSymmetric(TreeNode root) {
        doubleDfs(root, root);

        return ans;
    }
}
