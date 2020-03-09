package cn.sawyer.leetcodeOffer.kthLargest;

import cn.sawyer.leetcode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 二叉搜索树第K个大的节点
 * @author: sawyer
 * @create: 2020-02-27 12:24
 **/
public class Solution {

    List<Integer> list = new ArrayList<>();

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.right);
        list.add(root.val);
        dfs(root.left);

    }

    public int kthLargest(TreeNode root, int k) {
        dfs(root);

        return list.get(k - 1);
    }
}