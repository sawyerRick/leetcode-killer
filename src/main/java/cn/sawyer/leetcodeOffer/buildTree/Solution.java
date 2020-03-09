package cn.sawyer.leetcodeOffer.buildTree;

import cn.sawyer.leetcode.Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-28 15:30
 **/
public class Solution {

    Map<Integer, Integer> map = new HashMap<>();
    int[] preorder;
    int[] inorder;
    int preIdx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }

        return dfs(0, preorder.length);
    }

    TreeNode dfs(int left, int right) {
        if (left == right) {
            return null;
        }

        int rootVal = preorder[preIdx];
        TreeNode root = new TreeNode(rootVal);
        int mid = map.get(rootVal);
        preIdx++;
        root.left = dfs(left, mid);
        root.right = dfs(mid + 1, right);

        return root;
    }

}