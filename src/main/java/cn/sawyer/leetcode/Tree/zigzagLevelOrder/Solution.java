package cn.sawyer.leetcode.Tree.zigzagLevelOrder;

import cn.sawyer.leetcode.Tree.TreeNode;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 二叉树锯齿遍历，https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * @author: sawyer
 * @create: 2020-02-28 11:08
 **/
public class Solution {

    // 层次遍历
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Deque<Integer> subList = new LinkedList<>();

        boolean left = true;

        queue.add(root);
        queue.add(null); // 断层
        while (!queue.isEmpty()) {

            TreeNode curr = queue.poll();
            if (curr == null) {
                ans.add(new ArrayList<>(subList));
                subList.clear();
                left = !left;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                if (left) {
                    subList.addLast(curr.val);
                } else {
                    subList.addFirst(curr.val);
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }


        return ans;
    }
}