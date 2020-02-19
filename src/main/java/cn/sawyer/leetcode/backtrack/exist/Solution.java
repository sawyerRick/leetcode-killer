package cn.sawyer.leetcode.backtrack.exist;

/**
 * @program: LeetCode
 * @description: 单词搜索， https://leetcode-cn.com/problems/word-search/
 * @author: sawyer
 * @create: 2020-01-09 14:01
 **/
public class Solution {

    char[][] board;
    String word;
    int rowLen;
    int colLen;
    int[][] visited;
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    boolean backtrack(int row, int col, int start) {
        if (start == word.length() - 1) {
            return word.charAt(start) == board[row][col];
        }

        // 四个方向尝试
        visited[row][col] = 1;
        if (word.charAt(start) == board[row][col]) {
            for (int k = 0; k < 4; k++) {
                int x = row + direction[k][0];
                int y = col + direction[k][1];
                if (inArea(x, y) && visited[x][y] != 1) {
                    if (backtrack(x, y, start + 1)) {
                        return true;
                    }
                }
            }
        }
        visited[row][col] = 0;

        return false;
    }

    boolean inArea(int x, int y) {
        return x < rowLen && y < colLen && x >= 0 && y >= 0;
    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        rowLen = board.length;
        colLen = board[0].length;
        visited = new int[rowLen][colLen];


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (backtrack(i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
