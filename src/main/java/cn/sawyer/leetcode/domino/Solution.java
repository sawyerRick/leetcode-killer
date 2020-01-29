package cn.sawyer.leetcode.domino;

/**
 * @program: LeetCode
 * @description: 覆盖，多米诺，url:https://leetcode-cn.com/problems/broken-board-dominoes/
 * @author: sawyer
 * @create: 2019-12-21 23:35
 **/

// 尝试用回溯+剪枝
public class Solution {
    private int max = 0;
    private int count = 0;
    private int n;
    private int m;
    private int[][] map;

    public void backtrack(int row, int col) {
        // 超过行数 得一个结果
        if (row >= n) {
            max = Math.max(max, count);
            return;
        }

        // 超过列数，行加1
        if (col >= m) {
            backtrack(row + 1, 0);
            return;
        }

        // 坏格子或者下过的格子
        if (map[row][col] > 0) {
            backtrack(row, col + 1);
            return;
        }

        // 横着放
        boolean h = false;
        if (col < m - 1 && map[row][col + 1] == 0) {
            h = true;
            count++;
            map[row][col]++;
            map[row][col + 1]++;
            backtrack(row, col + 2);
            count--;
            map[row][col + 1]--;
            map[row][col]--;
        }

        // 竖着放
        boolean v = false;
        if (row < n - 1 && map[row + 1][col] == 0) {
            v = true;
            count++;
            map[row][col]++;
            map[row + 1][col]++;
            backtrack(row, col + 1);
            count--;
            map[row][col]--;
            map[row + 1][col]--;
        }

        // 横竖不行
        if (!v && !h) {
            backtrack(row, col + 2);
        }

    }

    public int domino(int n, int m, int[][] broken) {
        this.map = new int[n][m];
        this.n = n;
        this.m = m;

        for (int i = 0; i < broken.length; i++) {
            int[] item = broken[i];
            map[item[0]][item[1]] = 2;
        }
        backtrack(0, 0);

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.domino(2, 3, new int[][]{{1, 0}, {1, 1}});
        System.out.println("i = " + i);
    }
}
