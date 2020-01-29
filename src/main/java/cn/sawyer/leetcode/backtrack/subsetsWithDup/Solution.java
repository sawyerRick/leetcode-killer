package cn.sawyer.leetcode.backtrack.subsetsWithDup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2019-12-20 18:38
 **/
// 子集2(输入有重复元素)：https://leetcode-cn.com/problems/subsets-ii/
// 回溯+剪枝
class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    private void backtrack(int[] nums, List<Integer> list, int start) {
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            backtrack(nums, list, i + 1);
            list.remove(list.size() - 1);
        }

        result.add(new ArrayList<>(list));
    }

    // 经典的回溯+剪枝
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), 0);

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.subsetsWithDup(new int[]{1, 2, 2, 3});
        for (List<Integer> a : lists) {
            for (Integer integer : a) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

}
