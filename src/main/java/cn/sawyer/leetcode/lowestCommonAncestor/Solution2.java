package cn.sawyer.leetcode.lowestCommonAncestor;

import cn.sawyer.leetcode.Tree.TreeNode;

/**
 * @program: LeetCode
 * @description: 二叉搜索树的最近公共祖先，https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * @author: sawyer
 * @create: 2020-02-18 14:11
 **/

// 搜索树的可以优化，找分裂点
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int pVal = p.val;

        int qVal = q.val;

        TreeNode node = root;

        // 迭代找分裂点
        while (node != null) {

            int parentVal = node.val;
            // pq都比v大，往右走
            if (pVal > parentVal && qVal > parentVal) {
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                // pq都比v小，往左走
                node = node.left;
            } else {
                // 否则找到分裂点
                return node;
            }
        }
        return null;
    }
}
