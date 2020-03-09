package cn.sawyer.contest.contest179.numTimesAllBlue;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 灯泡开关3
 * @author: sawyer
 * @create: 2020-03-08 11:00
 **/
public class Solution {

    public int numTimesAllBlue(int[] light) {

        boolean[] map = new boolean[light.length + 1];
        Arrays.fill(map, false);

        int left = light[0];
        int right = light[0];
        int ans = 0;
        int size = 0;

        for (int i = 0; i < light.length; i++) {

            int l = light[i];
            size++;
            map[l] = true;

            while (right < light.length && map[right + 1]) {
                right++;
            }

            while (map[left - 1]) {
                left--;
            }

            if (map[1] && right - left + 1 == size) {
                System.out.println(left + ", " + right);
                ans++;
            }
        }

        return ans;
    }
}