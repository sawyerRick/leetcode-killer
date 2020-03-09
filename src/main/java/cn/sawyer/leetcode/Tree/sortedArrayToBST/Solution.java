package cn.sawyer.leetcode.Tree.sortedArrayToBST;

import cn.sawyer.leetcode.Tree.TreeNode;

/**
 * @program: LeetCode
 * @description: 将有序数组转为搜索二叉树，https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * @author: sawyer
 * @create: 2020-02-20 11:03
 **/
public class Solution {
    int[] nums;

    TreeNode dfs(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        if ((left + right) % 2 == 1) {
            mid++;
        }
        TreeNode node = new TreeNode(nums[mid]);

        node.left = dfs(left, mid - 1);
        node.right = dfs(mid + 1, right);

        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        TreeNode root = dfs(0, nums.length - 1);

        return root;
    }
}
