package interview.ali;

import cn.sawyer.leetcode.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-13 17:01
 **/
public class Solution1 {
    public int sum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> subSum = new Stack<>();
        queue.add(root);
        queue.add(null);
        int ans = 0;

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                int multi = 1;
                int subAns = 0;
                while (!subSum.isEmpty()){
                    subAns += multi * subSum.pop();
                    multi *= 10;
                }
                ans += subAns;

                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
            } else {
                subSum.add(curr.val);
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

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int ans = solution1.sum(root);
        System.out.println(ans);
    }

}
