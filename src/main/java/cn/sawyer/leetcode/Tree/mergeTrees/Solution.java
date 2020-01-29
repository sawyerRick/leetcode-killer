package cn.sawyer.leetcode.Tree.mergeTrees;

import cn.sawyer.leetcode.Tree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: mergeTrees，https://leetcode-cn.com/problems/merge-two-binary-trees/
 * @author: sawyer
 * @create: 2020-01-23 13:39
 **/
public class Solution {

    // dfs
    TreeNode dfs(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }

        if (t2 == null) {
            return t1;
        }

        t1.val += t2.val;
        t1.left = dfs(t1.left, t2.left);
        t1.right = dfs(t1.right, t2.right);
        return t1;
    }

    // 层次遍历
    TreeNode layer(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        // 节点成双入队
        Queue<TreeNode[]> q = new LinkedList<>();

        q.add(new TreeNode[]{t1, t2});

        while (!q.isEmpty()) {
            TreeNode[] curr = q.remove();

            // 任意一个为Null表示不用处理
            if (curr[0] == null || curr[1] == null) {
                continue;
            }

            curr[0].val += curr[1].val;

            if (curr[0].left != null) {
                q.add(new TreeNode[]{curr[0].left, curr[1].left});
            } else {
                curr[0].left = curr[1].left;
            }

            if (curr[0].right != null) {
                q.add(new TreeNode[]{curr[0].right, curr[1].right});
            } else {
                curr[0].right = curr[1].right;
            }
        }

        return t1;
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//        return dfs(t1, t2);

        return layer(t1, t2);
    }
}
