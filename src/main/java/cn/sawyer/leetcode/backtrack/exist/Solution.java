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
    boolean find;
    int[][] visited;
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    void backtrack(int row, int col, String curr) {
        curr += board[row][col];

        if (curr.equals(word)) {
            find = true;
            return;
        } else if (curr.length() >= word.length()) {
            // 快速失败
            return;
        }
        String tmp = curr;
        visited[row][col] = 1;
        for (int k = 0; k < 4; k++) {
            int x = row + direction[k][0];
            int y = col + direction[k][1];
            if (x >= rowLen || y >= colLen || x < 0 || y < 0 || visited[x][y] == 1) {
            } else {
                backtrack(x, y, curr);
            }
        }
        visited[row][col] = 0;
        curr = tmp;

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
                    backtrack(i, j, "");
                }
            }
        }


        return find;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean a = s.exist(new char[][]{{'a'}}, "a");
        System.out.println(a);
    }
}
