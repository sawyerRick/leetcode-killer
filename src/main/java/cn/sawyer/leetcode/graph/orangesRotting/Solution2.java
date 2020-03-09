package cn.sawyer.leetcode.graph.orangesRotting;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 再写一遍
 * @author: sawyer
 * @create: 2020-03-04 16:02
 **/
public class Solution2 {

    // 上左下右
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};
    int R;
    int C;

    public int orangesRotting(int[][] grid) {
        R = grid.length;
        C = grid[0].length;

        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        // 初始化
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 2) {
                    int index = r * C + c;
                    queue.add(index);
                    map.put(index, 0);
                }
            }
        }

        // bfs
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int r = index / C;
            int c = index % C;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (inArea(nr, nc) && grid[nr][nc] == 1) {
                    System.out.println(1);
                    int nIdx = nr * C + nc;
                    grid[nr][nc] = 2;

                    queue.add(nIdx);
                    map.put(nIdx, map.get(index) + 1);
                    ans = map.get(nIdx);
                }
            }
        }

        for (int[] rows : grid) {
            for (int i : rows) {
                if (i == 1) {
                    return -1;
                }
            }
        }

        return ans;
    }

    private boolean inArea(int r, int c) {

        return r >= 0 && r < R && c >= 0 && c < C;
    }

    public static void main(String[] args) {
        Class clazz = Solution2.class;
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader.getResource(""));
        System.out.println(clazz.getResource("/"));
        Vector vector = new Vector();
        vector.add("a");
        vector.get(0);
        Collections.synchronizedList(vector);
    }

}
