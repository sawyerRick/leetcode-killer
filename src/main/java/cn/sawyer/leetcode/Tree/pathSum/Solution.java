package cn.sawyer.leetcode.Tree.pathSum;

import cn.sawyer.leetcode.Tree.TreeNode;

/**
 * @program: LeetCode
 * @description: 路径总和1，https://leetcode-cn.com/problems/path-sum/
 * @author: sawyer
 * @create: 2020-02-10 15:59
 **/
public class Solution {

    boolean find = false;
    int sum;

    void dfs(TreeNode root, int curr) {
        if (root == null || find) {
            return;
        }

        curr += root.val;
        if (curr == sum && root.left == null && root.right == null) {
            find = true;
            return;
        }
        dfs(root.left, curr);
        dfs(root.right, curr);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        this.sum = sum;
        dfs(root, 0);

        return find;
    }
}
