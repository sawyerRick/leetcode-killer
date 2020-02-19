package cn.sawyer.leetcodeOffer.levelOrder;

import cn.sawyer.leetcode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 从上到下打印二叉树3，https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * @author: sawyer
 * @create: 2020-02-15 16:06
 **/
public class Solution3 {

    List<List<Integer>> ans = new ArrayList<>();

    // 递归
    void dfs(TreeNode root, int level) {
        // 增加子数组
        if (ans.size() == level) {
            ans.add(new ArrayList<>());
        }

        ans.get(level).add(root.val);

        if (root.left != null) {
            dfs(root.left, level + 1);
        }

        if (root.right != null) {
            dfs(root.right, level + 1);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return ans;
        }

        dfs(root, 0);
        for (int i = 1; i < ans.size(); i += 2) {
            Collections.reverse(ans.get(i));
        }
        return ans;
    }
}
