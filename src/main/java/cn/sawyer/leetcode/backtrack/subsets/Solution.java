package cn.sawyer.leetcode.backtrack.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 子集
 * @author: sawyer
 * @create: 2019-12-20 18:40
 **/

// 回溯
// 二进制算法
class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    private void backtrack(int[] nums, List<Integer> list, int start) {
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, list, i + 1);
            list.remove(list.size() - 1);
        }

        result.add(new ArrayList<>(list));
    }

    // 经典的回溯
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, new ArrayList<>(), 0);

        return result;
    }

    // 二进制算法
    public List<List<Integer>> subsets2(int[] nums) {
        int times = 1 << nums.length;
        for (int i = 0; i < times; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1)== 1) {
                    list.add(nums[j]);
                }
            }
            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        List<List<Integer>> lists = solution.subsets(new int[]{1, 2, 3});

        List<List<Integer>> lists = solution.subsets2(new int[]{1, 2, 3});
        for (List<Integer> a : lists) {
            for (Integer integer : a) {
                System.out.print(integer);
            }
            System.out.println();
        }

    }
}
