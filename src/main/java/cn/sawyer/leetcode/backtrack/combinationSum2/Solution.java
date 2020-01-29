package cn.sawyer.leetcode.backtrack.combinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2019-12-20 17:18
 **/

// 回溯+剪枝，（回溯算法模板：构造回溯N叉树，以前序遍历的思想来回溯和剪枝）
public class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    private int target;

    private void backtrack(int start, int[] candidates, List<Integer> list, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 剪枝
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            backtrack(i + 1, candidates, list, sum + candidates[i]);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        Arrays.sort(candidates);
        backtrack(0, candidates, new ArrayList<>(), 0);

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
        for (List<Integer> a : lists) {
            for (Integer integer : a) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
