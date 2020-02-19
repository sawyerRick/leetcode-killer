package cn.sawyer.leetcode.minMeetingRooms;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 会议室2，https://leetcode-cn.com/problems/meeting-rooms-ii/
 * @author: sawyer
 * @create: 2020-02-19 13:09
 **/
public class Solution {
    public int minMeetingRooms(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Queue<Integer> minHeap = new PriorityQueue<>(); // 保存正在用的各个会议室的结束时间

        for (int i = 0; i < intervals.length; i++) {
            if (minHeap.isEmpty()) {
                minHeap.add(intervals[i][1]);
            } else if (intervals[i][0] < minHeap.peek()) {
                // 冲突
                minHeap.add(intervals[i][1]);
            } else {
                // 使用当前的
                minHeap.poll();
                minHeap.add(intervals[i][1]);
            }
        }

        return minHeap.size();
    }
}