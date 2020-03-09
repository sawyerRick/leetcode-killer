package cn.sawyer.leetcodeOffer.movingCount;

/**
 * @program: LeetCode
 * @description: 机器人的运动范围，https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * @author: sawyer
 * @create: 2020-03-06 11:56
 **/
public class Solution {
    int[] dr = new int[]{1, 0, -1, 0};
    int[] dc = new int[]{0, 1, 0, -1};

    int R;
    int C;
    int k;

    int count;
    boolean[][] visited;

    void dfs(int r, int c) {

        count++;
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (inArea(nr, nc) && !visited[nr][nc] && sums(nr) + sums(nc) <= k) {
                dfs(nr, nc);
            }
        }
    }

    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        this.k = k;
        R = m;
        C = n;

        dfs(0, 0);

        return count;
    }

    int sums(int x) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    boolean inArea(int r, int c) {
        return r < R && r >= 0 && c < C && c >= 0;
    }
}