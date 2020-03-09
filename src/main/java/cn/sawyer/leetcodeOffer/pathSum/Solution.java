package cn.sawyer.leetcodeOffer.pathSum;

import cn.sawyer.leetcode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 二叉树中和为某一值的路径，https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * @author: sawyer
 * @create: 2020-03-07 15:29
 **/
public class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    int sum;

    void dfs(TreeNode root, int curr, List<Integer> sub) {
        if (root == null) {
            return;
        }
        curr += root.val;
        sub.add(root.val);
        if (curr == sum && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(sub));
        }
        dfs(root.left, curr, sub);
        dfs(root.right, curr, sub);
        System.out.println(sub.size());
        sub.remove(sub.size() - 1);
    }


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        dfs(root, 0, new ArrayList<>());


        return ans;
    }
}