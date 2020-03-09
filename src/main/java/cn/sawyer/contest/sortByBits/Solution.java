package cn.sawyer.contest.sortByBits;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-22 22:32
 **/
public class Solution {
    public int[] sortByBits(int[] arr) {
        if (arr.length == 0) {
            return new int[0];
        }

        int[][] map = new int[arr.length][2];
        for (int i = 0; i < map.length; i++) {
            int count = 0;
            int curr = arr[i];
            int max = 32;
            while (max > 0) {
                if ((curr & 1) == 1) {
                    count++;
                }
                curr = curr >>> 1;
                max--;
            }
            map[i][0] = count;
            map[i][1] = i;
        }
        Arrays.sort(map, (a, b) -> a[0] == b[0] ? arr[a[1]] - arr[b[1]] : a[0] - b[0]);

        int[] a = new int[map.length];
        for (int i = 0; i < a.length; i++) {
            System.out.println(map[i][0] + "," + map[i][1]);
            a[i] = arr[map[i][1]];
        }

        return a;
    }
}