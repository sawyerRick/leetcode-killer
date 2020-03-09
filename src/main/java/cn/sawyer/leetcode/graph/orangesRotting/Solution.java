package cn.sawyer.leetcode.graph.orangesRotting;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 腐烂的🍊，https://leetcode-cn.com/problems/rotting-oranges/
 * @author: sawyer
 * @create: 2020-03-04 13:53
 **/

// 二维化一维公式：index = r * C + c
// 一维化二维：
// r = index / C；
// c = index % C
public class Solution {
    // 方向辅助表示
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};
    int R;
    int C;


    // 多源bfs
    public int orangesRotting(int[][] grid) {
        R = grid.length;
        C = grid[0].length;

        Queue<Integer> queue = new ArrayDeque<>(); // 保存坐标
        Map<Integer, Integer> depth = new HashMap<>(); // 保存橘子和对应时间
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c)
                if (grid[r][c] == 2) {
                    // 二维化一维
                    int index = r * C + c;
                    queue.add(index);
                    depth.put(index, 0);
                }

        int ans = 0;
        while (!queue.isEmpty()) {
            int index = queue.remove();
            // 一维化二维
            int r = index / C;
            int c = index % C;
            // 上下左右都走一遍
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                // 坐标合法，且有🍊
                if (inArea(nr, nc) && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int nIdx = nr * C + nc;
                    queue.add(nIdx);
                    depth.put(nIdx, depth.get(index) + 1);
                    ans = depth.get(nIdx);
                }
            }
        }

        for (int[] row: grid)
            for (int v: row)
                if (v == 1)
                    return -1;
        return ans;

    }

    private boolean inArea(int nr, int nc) {
        return 0 <= nr && nr < R && 0 <= nc && nc < C;
    }
}