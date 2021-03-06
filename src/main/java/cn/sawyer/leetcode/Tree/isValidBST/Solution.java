package cn.sawyer.leetcode.Tree.isValidBST;


import cn.sawyer.leetcode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 验证二叉搜索树，https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @author: sawyer
 * @create: 2020-01-10 12:18
 **/
public class Solution {

    // 中序遍历3
    List<Integer> list = new ArrayList<>();
    // dfs
    void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }

    public boolean isValidBST3(TreeNode root) {
        dfs(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                return false;
            }
        }

        return true;
    }


    // 方法一： 中序遍历升序
    boolean ans = true;

    long prev = -Long.MAX_VALUE;

    void inOrder(TreeNode node) {
        if (node == null || !ans) {
            return;
        }
        inOrder(node.left);
        if (ans) {
            ans = prev < node.val;
            prev = node.val;
        }
        inOrder(node.right);
    }

    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        boolean a = inOrderWithStack(root);

        return ans;
    }

    // 用栈中序遍历
    boolean inOrderWithStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        long last = -Long.MAX_VALUE;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            System.out.println(node.val);
            if (last < node.val) {
                last = node.val;
            } else {
                return false;
            }
            node = node.right;
        }

        return true;
    }
}
