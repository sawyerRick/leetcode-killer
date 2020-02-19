package cn.sawyer.leetcode.dynamicProgramming.canCompleteCircuit;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 加油站，https://leetcode-cn.com/problems/gas-station/
 * @author: sawyer
 * @create: 2020-02-01 15:14
 **/
public class Solution {

    public int canCompleteCircuit2(int[] gas, int[] cost) {

        for (int j = 0; j < gas.length; j++) {
            int currGas = 0;
            int i = j;
            for (; i < gas.length; i++) {
                int index = i % gas.length;
                currGas += gas[index];
                currGas -= cost[index];
                if (currGas < 0) {
                    break;
                }
            }
            if (i == gas.length) {
                return j;
            }
        }
        return -1;
    }

    // 从第一个gas[i] > cost[i]开始走
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int[][] gc = new int[gas.length][3];
        for (int i = 0; i < gas.length; i++) {
            gc[i][0] = gas[i];
            gc[i][1] = cost[i];
            gc[i][2] = i;
        }

        Arrays.sort(gc, (a, b) -> a[0] - a[1] - (b[0] - b[1]));
//        for (int i = 0; i < gc.length; i++) {
//            System.out.println(Arrays.toString(gc[i]));
//        }

        int start = gc[0][2];
        int currGas = 0;
        for (int i = start; i < gas.length; i++) {
            int index = i % gas.length;
            currGas += gas[index];
            currGas -= cost[index];
            if (currGas < 0) {
                return -1;
            }
        }

        return start;
    }
}
