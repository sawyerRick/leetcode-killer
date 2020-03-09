package cn.sawyer.leetcode.graph.wallsAndGates;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 墙与🚪，https://leetcode-cn.com/problems/walls-and-gates/
 * @author: sawyer
 * @create: 2020-03-04 16:36
 **/

// 思路，多源bfs，反向思考，从门到房间。
public class Solution {

    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};
    int R;
    int C;

    // 逐个bfs
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        final int INF = Integer.MAX_VALUE;
        R = rooms.length;
        C = rooms[0].length;

        Queue<Integer> queue = new LinkedList<>();
        // 初始化
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (rooms[r][c] == 0) {
                    int index = r * C + c;
                    queue.add(index);
                }
            }
        }

        while (!queue.isEmpty()) {

            int index = queue.poll();
            int r = index / C;
            int c = index % C;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                System.out.println(nr + ", " + nc);


                if (inArea(nr, nc) && rooms[nr][nc] == INF) {
                    rooms[nr][nc] = rooms[r][c] + 1;
                    int nIdx = nr * C + nc;
                    queue.add(nIdx);
                }
            }
        }
    }

    private boolean inArea(int nr, int nc) {
        return 0 <= nr && nr < R && 0 <= nc && nc < C;
    }
}