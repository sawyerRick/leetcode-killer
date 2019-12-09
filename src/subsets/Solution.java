package subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2019-12-08 23:07
 **/
public class Solution {

    // 子集
    // url: https://leetcode-cn.com/problems/subsets/
    // 回溯 + 约束编程
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        List<Integer> list = new ArrayList<>(tmp);
        res.add(list);
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }


    //  位运算求子集
    // 可选或可不选，二进制位运算可以表示
    public List<List<Integer>> binaryBit(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1) {
                    sub.add(nums[j]);
                }
            }
            res.add(sub);
        }
        return res;
    }

    public static void display(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.printf(integer + "");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> res = solution.subsets(nums);
        solution.binaryBit(nums);
    }
}
