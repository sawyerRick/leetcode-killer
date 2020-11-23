package cn.sawyer.leetcode.graph.maxAreaOfIsland;

/**
 * @program: LeetCode
 * @description: 岛屿的最大面积，https://leetcode-cn.com/problems/max-area-of-island/
 * @author: sawyer
 * @create: 2020-03-15 19:23
 **/

public class Solution {

    boolean[][] visited;

    int[] dr = new int[]{1, -1, 0, 0};
    int[] dc = new int[]{0, 0, 1, -1};

    int R;
    int C;

    int maxArea;
    int subArea;

    void dfs(int r, int c, int[][] grid) {
        subArea++;
        maxArea = Math.max(subArea, maxArea);
        visited[r][c] = true;
        // 上下左右
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (inArea(nr, nc) && !visited[nr][nc] && grid[nr][nc] == 1) {
                dfs(nr, nc, grid);
            }
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        R = grid.length;
        C = grid[0].length;
        visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    subArea = 0;
                    dfs(i, j, grid);
                }
            }
        }

        return maxArea;
    }

    boolean inArea(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}