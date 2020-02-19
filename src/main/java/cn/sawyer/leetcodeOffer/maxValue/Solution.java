package cn.sawyer.leetcodeOffer.maxValue;

/**
 * @program: LeetCode
 * @description: 礼物的最大价值，https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * @author: sawyer
 * @create: 2020-02-12 19:43
 **/
public class Solution {

    int max;
    int[][] grid;
    int m;
    int n;

    // 暴力回溯 (超时)
    void backtrack(int r, int c, int curr) {
        if (r >= m || c >= n) {
            return;
        }
        curr += grid[r][c];
        if (r == m - 1 && c == n - 1) {
            max = Math.max(curr, max);
        }
        backtrack(r + 1, c, curr);
        backtrack(r, c + 1, curr);
    }

    public int maxValue(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        backtrack(0, 0, 0);

        return max;
    }
}
