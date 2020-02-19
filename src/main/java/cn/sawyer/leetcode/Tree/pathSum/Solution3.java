package cn.sawyer.leetcode.Tree.pathSum;

import cn.sawyer.leetcode.Tree.TreeNode;

/**
 * @program: LeetCode
 * @description: 路径总和3，https://leetcode-cn.com/problems/path-sum-iii/
 * @author: sawyer
 * @create: 2020-02-10 16:11
 **/
public class Solution3 {
    // 每个节点都当成root遍历
    public int pathSum(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }

        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    int helper(TreeNode root, int sum){
        if(root == null) {
            return 0;
        }
        sum -= root.val;
        return (sum == 0 ? 1 : 0) + helper(root.left, sum) + helper(root.right, sum);
    }
}