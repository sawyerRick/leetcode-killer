package cn.sawyer.leetcode.merge56;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 合并区间
 * @author: sawyer
 * @create: 2019-12-30 14:23
 **/
public class Solution {
    class Interval implements Comparable<Interval>{
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            return Integer.compare(start, o.start);
        }
    }

    public int[][] merge(int[][] intervals) {
        List<Interval> list = new ArrayList<>();
        LinkedList<Interval> merged = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        Collections.sort(list);

        for (Interval e : list) {
            if (merged.isEmpty() || merged.getLast().end < e.start) {
                merged.add(e);
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, e.end);
            }
        }

        int[][] ans = new int[merged.size()][2];

        for (int i = 0; i < merged.size(); i++) {
            ans[i][0] = merged.get(i).start;
            ans[i][1] = merged.get(i).end;
        }



        return ans;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        int[][] nums = new int[][]{{1, 3}, {4, 2}};
        s.merge(nums);
        for (int[] num : nums) {
            for (int i : num) {
                System.out.print(i + " ");
            }
            System.out.println();
        }


    }
}
