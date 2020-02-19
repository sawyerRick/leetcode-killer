package cn.sawyer.leetcode.greedy.findMinArrowShots;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 用最少数量的箭引爆气球，https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * @author: sawyer
 * @create: 2020-02-08 17:20
 **/
public class Solution {
    // 贪心，转换为重叠区间问题
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0 || points[0].length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b)-> a[1] - b[1]);

        int lastEnd = points[0][1];
        int ans = 1;
        for (int i = 1; i < points.length; i++) {
            int start = points[i][0];
            if (start > lastEnd) {
                ans++;
                lastEnd = points[i][1];
            }
        }

        return ans;
    }
}
