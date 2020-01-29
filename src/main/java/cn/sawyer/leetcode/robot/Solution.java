package cn.sawyer.leetcode.robot;

/**
 * @program: LeetCode
 * @description: 机器人大冒险，url:https://leetcode-cn.com/problems/programmable-robot/submissions/
 * @author: sawyer
 * @create: 2019-12-21 23:08
 **/
class Solution {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int cx = 0;
        int cy = 0;

        while(cx <= x && cy <= y) {
            for (int i = 0; i < command.length(); i++) {
                if (command.charAt(i) == 'U') {
                    cy++;
                    if (cx == x && cy == y) {
                        return true;
                    }
                } else if (command.charAt(i) == 'R') {
                    cx++;
                    if (cx == x && cy == y) {
                        return true;
                    }
                }
                for (int m = 0; m < obstacles.length; m++) {
                    if (cx == obstacles[m][0] && cy == obstacles[m][1]) {
                        return false;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        boolean result = solution.robot("URR", new int[][]{}, 3, 2);
        System.out.println(result);
    }
}
