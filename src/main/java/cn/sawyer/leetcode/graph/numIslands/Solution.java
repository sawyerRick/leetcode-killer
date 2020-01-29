package cn.sawyer.leetcode.graph.numIslands;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 岛屿数量，https://leetcode-cn.com/problems/number-of-islands/
 * @author: sawyer
 * @create: 2020-01-08 20:41
 **/
class Solution {
    char[][] grid;
    int colLen;
    int rowLen;

    // dfs
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int ans = 0;
        this.grid = grid;
        this.colLen = grid[0].length;
        this.rowLen = grid.length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(i, j);
                }
            }
        }

        return ans;
    }

    // dfs回溯
    public void dfs(int row, int col) {
        // 走出边界
        if (row >= rowLen) {
            return;
        }

        if (col >= colLen) {
            return;
        }

        if (row < 0 || col < 0) {
            return;
        }

        // 决策叶子
        if (grid[row][col] == '0') {
            return;
        }

        // 删除走过的
        grid[row][col] = '0';

        // 上下左右走
        dfs(row, col + 1);
        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col - 1);

    }

    // bfs  细节：入队前要标记，否则会出现很多重复
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int ans = 0;
        int rl = grid.length;
        int cl = grid[0].length;

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = 0; // 抹掉小岛
                    queue.add(new Pair<>(i, j));
                    ans++;

                    // 扩散
                    while (!queue.isEmpty()) {
                        Pair<Integer, Integer> p = queue.remove();
                        int x = p.getKey();
                        int y = p.getValue();
                        if (x + 1 < rl && grid[x + 1][y] == '1') {
                            grid[x + 1][y] = '0';
                            queue.add(new Pair<>(x + 1, y));
                        }

                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            grid[x - 1][y] = '0';
                            queue.add(new Pair<>(x - 1, y));
                        }

                        if (y + 1 < cl && grid[x][y + 1] == '1') {
                            grid[x][y + 1] = '0';
                            queue.add(new Pair<>(x, y + 1));
                        }

                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            grid[x][y - 1] = '0';
                            queue.add(new Pair<>(x, y - 1));
                        }
                    }
                }
            }
        }



        return ans;
    }

}