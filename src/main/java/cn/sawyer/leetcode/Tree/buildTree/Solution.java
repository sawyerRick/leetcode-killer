package cn.sawyer.leetcode.Tree.buildTree;

import cn.sawyer.leetcode.Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 重建二叉树，https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * @author: sawyer
 * @create: 2020-02-28 14:30
 **/
public class Solution {

    // 前序：找根节点
    // 中序：找左右子树，递归

    // 储存 中序：k值-v下标
    Map<Integer, Integer> map = new HashMap<>();

    int[] preorder;
    int[] inorder;
    int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        this.preorder = preorder;
        this.inorder = inorder;

        return dfs(0, preorder.length);
    }

    TreeNode dfs(int lIdx, int rIdx) {
        if (lIdx == rIdx) {
            return null;
        }

        int rootVal = preorder[preIdx];
        TreeNode root = new TreeNode(rootVal);
        // 递归
        int mid = map.get(rootVal);
        preIdx++;
        root.left = dfs(lIdx, mid);
        root.right = dfs(mid + 1, rIdx);

        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}