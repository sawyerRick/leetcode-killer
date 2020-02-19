package cn.sawyer.leetcode.Tree.pathSum;

import cn.sawyer.leetcode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 路径总和2，https://leetcode-cn.com/problems/path-sum-ii/
 * @author: sawyer
 * @create: 2020-02-10 16:10
 **/
public class Solution2 {

    List<List<Integer>> ans = new ArrayList<>();
    int target;

    void dfs(TreeNode root, int curr, List<Integer> list) {
        if (root == null) {
            return;
        }
        curr += root.val;
        list.add(root.val);
        if (curr == target && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(list));
        }
        dfs(root.left, curr, list);
        dfs(root.right, curr, list);
        list.remove(list.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        target = sum;
        dfs(root, 0, new ArrayList<>());

        return ans;
    }
}
