package cn.sawyer.contest.maxEvents;

import java.util.*;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-16 11:33
 **/
public class Solution {
    public int maxEvents(int[][] events) {
        if (events.length == 0) {
            return 0;
        }

        // 按start排序
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        int count = 0;
        Map<Integer, Boolean> memo = new HashMap<>();
        for (int i = 0; i < events.length; i++) {
            for (int j = events[i][0]; j < events[i][1]; j++) {
                if (!memo.containsKey(j)) {
                    count++;
                    memo.put(j, true);
                    break;
                }
            }
        }

        for (Map.Entry<Integer, Boolean> entry : memo.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }

        return count;
    }
}
