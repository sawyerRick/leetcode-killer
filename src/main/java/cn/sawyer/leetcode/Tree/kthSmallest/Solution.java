package cn.sawyer.leetcode.Tree.kthSmallest;

import cn.sawyer.leetcode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 二叉搜索树中第k个小的元素，https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * @author: sawyer
 * @create: 2020-02-17 14:36
 **/
class Solution {

    int ans = -1;
    int curr = 1;
    int k;

    void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        curr++;
        if (curr == k) {
            ans = node.val;
        }
        dfs(node.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);

        return ans;
    }
}
