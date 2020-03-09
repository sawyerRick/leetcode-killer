package cn.sawyer.leetcodeOffer.exist;

/**
 * @program: LeetCode
 * @description: 矩阵中的路径，https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * @author: sawyer
 * @create: 2020-03-06 11:24
 **/
public class Solution {

    int[] dr = new int[]{1, 0, -1, 0};
    int[] dc = new int[]{0, 1, 0, -1};

    int R;
    int C;

    char[][] board;
    String word;
    boolean[][] visited;

    boolean find = false;

    void dfs(int r, int c, int start) {
        if (word.length() - 1 == start) {
            find = word.charAt(start) == board[r][c];
            return;
        }

        visited[r][c] = true;
        if (board[r][c] == word.charAt(start)) {
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (inArea(nr, nc) && !visited[nr][nc]) {
                    if (find) {
                        return;
                    }
                    dfs(nr, nc, start + 1);
                }
            }
        }
        visited[r][c] = false;
    }

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        this.board = board;
        this.word = word;
        this.R = board.length;
        this.C = board[0].length;
        visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (!find) {
                    dfs(r, c, 0);
                } else {
                    break;
                }
            }
        }

        return find;
    }

    boolean inArea(int r, int c) {
        return r < R && r >= 0 && c < C && c >= 0;
    }
}