package cn.sawyer.leetcode.canAttendMeetings;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 会议室，https://leetcode-cn.com/problems/meeting-rooms/
 * @author: sawyer
 * @create: 2020-02-19 13:03
 **/
public class Solution {

    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) {
            return true;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int lastEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (lastEnd > intervals[i][0]) {
                return false;
            }
            lastEnd = intervals[i][1];
        }

        return true;
    }
}
