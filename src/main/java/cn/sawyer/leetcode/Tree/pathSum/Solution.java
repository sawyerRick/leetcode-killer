package cn.sawyer.leetcode.Tree.pathSum;

import cn.sawyer.leetcode.Tree.TreeNode;

/**
 * @program: LeetCode
 * @description: 路径总和，https://leetcode-cn.com/problems/path-sum-iii/
 * @author: sawyer
 * @create: 2020-01-28 15:01
 **/
public class Solution {
    int sum;
    int count;

    // dfs
    void dfs(TreeNode node, int curr) {
        if (node == null) {
            return;
        }

        if (curr + node.val == sum) {
            count++;
        }
        dfs(node.left, curr); // 不选当前，走左
        dfs(node.left, curr + node.val); // 选当前，走左
        dfs(node.right, curr);
        dfs(node.right, curr + node.val);
    }

    public int pathSum(TreeNode root, int sum) {
        this.sum = sum;

        dfs(root, 0);

        return count;
    }
}
