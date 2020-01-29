package cn.sawyer.leetcode.backtrack.combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2019-12-20 16:02
 **/

// 回溯+剪枝
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private int target;

    private void backtrack(int start, int[] candidates, List<Integer> list, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length && target - sum >= candidates[i]; i++) {
            list.add(candidates[i]);
            backtrack(i, candidates, list, sum + candidates[i]);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        Arrays.sort(candidates);
        backtrack(0, candidates, new ArrayList<>(), 0);

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combinationSum(new int[]{2, 3, 5, 4, 7}, 7);
        System.out.println(res.size());
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
