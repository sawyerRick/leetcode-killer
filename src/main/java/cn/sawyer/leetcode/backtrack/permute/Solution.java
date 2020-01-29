package cn.sawyer.leetcode.backtrack.permute;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 全排列，回溯算法。 回溯 --》 决策树
 * @author: sawyer
 * @create: 2019-12-20 15:16
 **/
class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public void backtrack(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));

            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            // 做选择
            backtrack(nums, list);
            // 撤销选择
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>());

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permute(new int[]{1, 2, 3});
        for (List<Integer> a : lists) {
            for (Integer integer : a) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}