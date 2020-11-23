package interview.it;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-12 19:06
 **/
public class Solution1 {

    static int LEN;
    static int count;
    static int[][] memo;

    static boolean dfs(int[][] grid,int r, int c) {
        if (!inArea(r, c) || grid[r][c] == 1) {
            return false;
        }
        if (r == 1 && c == LEN - 1) {
            return true;
        }
        if (memo[r][c] == 1) {
            return true;
        }

        // 右
        boolean ans1 = dfs(grid, r, c + 1);
        // 右上
        boolean ans2 = dfs(grid, r - 1, c + 1);
        // 右下
        boolean ans3 = dfs(grid, r + 1, c + 1);
        if (ans1 || ans2 || ans3) {
            count++;
            memo[r][c] = 1;
        }

        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine());
        LEN = len;
        int[][] grid = new int[2][len];
        memo = new int[2][len];
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();

        for (int i = 0; i < LEN; i++) {
            grid[0][i] = line1.charAt(i) == '.'? 0: 1;
            grid[1][i] = line2.charAt(i) == '.'? 0: 1;
        }
        dfs(grid, 0, 0);
        System.out.println(count == 0? -1 : count);
    }

    static boolean inArea(int r, int c) {
        return r >= 0 && r < 2 && c < LEN && c >= 0;
    }
}
