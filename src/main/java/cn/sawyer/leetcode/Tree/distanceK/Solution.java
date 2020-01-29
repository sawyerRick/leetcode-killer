package cn.sawyer.leetcode.Tree.distanceK;

import cn.sawyer.leetcode.Tree.TreeNode;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 二叉树中所有距离为K的节点，https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/comments/
 * @author: sawyer
 * @create: 2020-01-17 12:14
 **/
public class Solution {
    Map<TreeNode, TreeNode> parent = new HashMap<>();

    // 先dfs建立指向父节点的索引，然后从target节点开始bfs遍历
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        // dfs建立父索引
        dfs(null, root);

        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> seen = new HashSet<>();

        // 从target开始bfs
        queue.add(null); // 分层标记，添加一个null垫背，每次queue出队到此标记，就是一层遍历结束
        queue.add(target);

        seen.add(null);
        seen.add(target);

        int dist = 0;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            // 完美的分层机制
            if (curr == null) {
                if (dist == K) {
                    for (TreeNode n: queue)
                        ans.add(n.val);
                    return ans;
                }
                queue.add(null);
                dist++;
                System.out.println(queue.size());
            } else {
                // 向上
                if (!seen.contains(parent.get(curr))) {
                    seen.add(parent.get(curr));
                    queue.add(parent.get(curr));
                }

                // 向下
                if (!seen.contains(curr.left)) {
                    seen.add(curr.left);
                    queue.add(curr.left);
                }

                if (!seen.contains(curr.right)) {
                    seen.add(curr.left);
                    queue.add(curr.right);
                }
            }
        }

        return ans;
    }

    public void dfs(TreeNode root, TreeNode curr) {
        if (curr == null) {
            return;
        }
        parent.put(curr, root);
        dfs(curr, curr.left);
        dfs(curr, curr.right);
    }
}
