package cn.sawyer.leetcode.Tree.buildTree;

import cn.sawyer.leetcode.Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 从前序遍历和中序遍历构造二叉树，https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @author: sawyer
 * @create: 2020-01-19 15:33
 **/
public class Solution {

    private int[] preorder;
    private Map<Integer, Integer> hash;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        this.preorder = preorder;
        this.hash = new HashMap<>();
        // put前序的value,对应中序的index
        for (int i = 0; i < inLen; i++) {
            hash.put(inorder[i], i);
        }

        return buildTree(0, preLen - 1, 0, inLen - 1);
    }


    private TreeNode buildTree(int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int preValue = preorder[preLeft]; // 前序value
        TreeNode root = new TreeNode(preValue);
        int inIndex = hash.get(preValue); // 前序value在中序的index
        // 左：
        // 前序：左边界+1，右边界=
        root.left = buildTree(preLeft + 1, inIndex - inLeft + preLeft,
                inLeft, inIndex - 1);
        root.right = buildTree(inIndex - inLeft + preLeft + 1, preRight,
                inIndex + 1, inRight);
        return root;
    }
}

