package cn.sawyer.leetcode.subsets;

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

    // 枚举法
    // 逐个枚举，空集的幂集只有空集，每增加一个元素，让之前幂集中的每个集合，追加这个元素，就是新增的子集。
    public List<List<Integer>> add(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int originSize = res.size();
            for (int j = 0; j < originSize; j++) {
                List<Integer> list = new ArrayList<>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
        }

        return res;
    }

    // 满二叉树
    // 集合中每个元素的选和不选，构成了一个满二叉状态树，比如，左子树是不选，右子树是选，从根节点、到叶子节点的所有路径，构成了所有子集。可以有前序、中序、后序的不同写法，结果的顺序不一样。本质上，其实是比较完整的中序遍历。
    public List<List<Integer>> binaryTree(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        inOrder(nums, 0, new ArrayList<>(), lists);
        return lists;
    }

    // 中序遍历
    public void inOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) return;
        subset = new ArrayList<Integer>(subset);

        inOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        // 这里
        res.add(subset);
        inOrder(nums, i + 1, subset, res);
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
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = solution.subsets(nums);
        res = solution.add(nums);
        res = solution.binaryTree(nums);
        display(res);
    }
}
