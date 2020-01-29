package cn.sawyer.leetcode.backtrack.permuteUnique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 全排列2 url:https://leetcode-cn.com/problems/permutations-ii/
 * @author: sawyer
 * @create: 2019-12-20 19:18
 **/
// 回溯+剪枝（一般有重复的都需要排序，然后剪枝 减掉重复的枝叶） 核心：画决策树，剪枝
// 比较难理解的一题
public class Solution {

    private List<List<Integer>> result = new ArrayList<>();
    private boolean[] used;

    private void backtrack(int[] nums, List<Integer> list) {

        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // （因为是有重复的，所以不能用list.contains()）
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            backtrack(nums, list);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>());

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permuteUnique(new int[]{1, 1, 2});
        System.out.println("size:" + lists.size());
        for (List<Integer> a : lists) {
            for (Integer integer : a) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
