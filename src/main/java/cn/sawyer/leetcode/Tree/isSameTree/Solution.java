package cn.sawyer.leetcode.Tree.isSameTree;

import cn.sawyer.leetcode.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 相同的🌲，https://leetcode-cn.com/problems/same-tree/
 * @author: sawyer
 * @create: 2020-02-05 00:18
 **/
public class Solution {

    // 层次遍历
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(p);
        queue.add(q);

        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();

            if (n1 == null && n2 == null) {
                continue;
            } else if (n1 == null || n2 == null) {
                return false;
            }

            if (n1.val != n2.val) {
                return false;
            } else {
                queue.add(n1.left);
                queue.add(n2.left);
                queue.add(n1.right);
                queue.add(n2.right);
            }
        }

        return true;
    }


    // dfs
    boolean ans = true;
    void dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return;
        }

        if (root1 == null || root2 == null || !ans) {
            ans = false;
            return;
        }

        int c1 = root1.val;
        int c2 = root2.val;
        if (c1 != c2) {
            ans = false;
            return;
        }
        dfs(root1.left, root2.left);
        dfs(root1.right, root2.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        dfs(p, q);

        return ans;
    }
}
