package cn.sawyer.leetcode.dynamicProgramming.calculateMinimumHP;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 地下城游戏，https://leetcode-cn.com/problems/dungeon-game/
 * @author: sawyer
 * @create: 2020-01-26 15:23
 **/
public class Solution {

    int[][] dungeon;
    int min = Integer.MAX_VALUE;

    // 暴力回溯 超时
    void dfs(int row, int col, int hp, int need) {
        if (row > dungeon.length - 1) {
            return;
        }

        if (col > dungeon[0].length - 1) {
            return;
        }

        hp += dungeon[row][col];

        if (dungeon[row][col] < 0) {
            need = Math.min(need, hp);
        }

        // 一个结果
        if (col == dungeon[0].length - 1 && row == dungeon.length - 1) {
            min = Math.min(min, Math.abs(need) + 1);
        }

        // 下
        dfs(row + 1, col, hp, need);

        // 右
        dfs(row, col + 1, hp, need);
    }

    // 回溯改进，备忘录 自顶向下
    // 动态方程： dp[r][c] = max(0, min(dp[r+1][c], dp[r][c+1]) - curr);
    // min(dp[r+1][c], dp[r][c+1]) 表示下或右
    int dpSolution(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;

        int[][] dp = new int[n][m];

        dp[n - 1][m - 1] = Math.max(0, 0 - dungeon[n - 1][m - 1]); // 终点

        // 初始化最右列
        for (int i = n - 2; i >= 0; i--) {
            dp[i][m - 1] = Math.max(0, dp[i + 1][m - 1] - dungeon[i][m - 1]);
        }

        // 初始化底
        for (int i = m - 2; i >= 0; i--) {
            dp[n - 1][i] = Math.max(0, dp[n - 1][i + 1] - dungeon[n - 1][i]);
        }

        for (int i = n - 2; i >=0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                dp[i][j] = Math.max(0, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }

        for (int[] ints : dp) {
            for (int d : ints) {
                System.out.print(d + " ");
            }
            System.out.println();
        }


        return dp[0][0] + 1;
    }


    public int calculateMinimumHP(int[][] dungeon) {
        this.dungeon = dungeon;
        dfs(0, 0, 0, 0);

        return min;
    }
}
