package interview;

import cn.sawyer.leetcode.Tree.TreeNode;

import java.util.*;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-06 15:26
 **/
public class Solution {
    public List<List<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        boolean reverse = false;

        queue.add(pRoot);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                if (reverse) {
                    Collections.reverse(sub);
                    ans.add(new ArrayList<>(sub));
                }
                reverse = !reverse;
                sub.clear();

                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                sub.add(curr.val);
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