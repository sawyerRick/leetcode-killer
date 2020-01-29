package cn.sawyer.leetcode.dynamicProgramming.minimumTotal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 三角形最小路径和，https://leetcode-cn.com/problems/triangle/
 * @author: sawyer
 * @create: 2020-01-25 16:39
 **/
public class Solution {
    List<List<Integer>> triangle;
    int min = Integer.MAX_VALUE;

    // 暴力递归(超时)
    void dfs(int index, int layer, int sum) {
        if (layer >= triangle.size()) {
            min = Math.min(min, sum);
            return;
        }

        sum += triangle.get(layer).get(index);
        System.out.println(layer + "," + index);

        dfs(index, layer + 1, sum); // 左
        dfs(index + 1, layer + 1, sum); // 右
    }

    // 备忘录递归 自顶向下
    int[][] memo;
    int dfsMemo(int index, int layer) {
        if (layer >= triangle.size()) {
            return 0;
        }

        if (memo[layer][index] != Integer.MIN_VALUE) {
            return memo[layer][index];
        }
        int left = dfsMemo(index, layer + 1);
        int right = dfsMemo(index + 1, layer + 1);
        memo[layer][index] = Math.min(left, right) + triangle.get(layer).get(index);

        return memo[layer][index];
    }

    // i相邻 下一层的i, i + 1;
    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        this.memo = new int[triangle.size()][triangle.size()];
        for (int[] ints : memo) {
            Arrays.fill(ints, Integer.MIN_VALUE);
        }
        dfsMemo(0, 0);

        return min;
    }
}
