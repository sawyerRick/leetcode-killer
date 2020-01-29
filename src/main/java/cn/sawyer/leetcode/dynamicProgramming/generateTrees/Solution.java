package cn.sawyer.leetcode.dynamicProgramming.generateTrees;

import cn.sawyer.leetcode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 不同的二叉搜索树二，https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * @author: sawyer
 * @create: 2020-01-25 15:25
 **/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dfs(3));
    }

    int dfs(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        int subProb = 0;
        for (int i = 1; i <= n; i++) {
            subProb += (dfs(i - 1) * dfs(n - i));
        }

        return subProb;
    }

    List<TreeNode> list = new ArrayList<>();

    public List<TreeNode> generateTrees(int n) {



        return null;
    }
}
