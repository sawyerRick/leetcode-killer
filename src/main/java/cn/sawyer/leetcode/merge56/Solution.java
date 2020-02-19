package cn.sawyer.leetcode.merge56;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 合并区间
 * @author: sawyer
 * @create: 2019-12-30 14:23
 **/
public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][];
        }

        // 按start排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        LinkedList<int[]> ans = new LinkedList<>();
        for (int[] i : intervals) {
            if (ans.isEmpty() || ans.getLast()[1] < i[0] ) {
                ans.add(i);
            } else {
                ans.getLast()[1] = Math.max(i[1], ans.getLast()[1]);
            }
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}
