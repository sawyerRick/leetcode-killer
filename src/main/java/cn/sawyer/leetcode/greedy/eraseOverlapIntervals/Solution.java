package cn.sawyer.leetcode.greedy.eraseOverlapIntervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: LeetCode
 * @description: 无重叠区间，https://leetcode-cn.com/problems/non-overlapping-intervals/
 * @author: sawyer
 * @create: 2020-02-08 16:50
 **/
public class Solution {

    // 排序
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b)-> a[1] - b[1]);

        int lastEnd = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            if (start >= lastEnd) {
                ans++;
                lastEnd = intervals[i][1];
            }
        }

        return intervals.length - ans;
    }
}
