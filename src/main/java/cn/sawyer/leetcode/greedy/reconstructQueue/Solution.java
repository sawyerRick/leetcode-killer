package cn.sawyer.leetcode.greedy.reconstructQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 根据身高重建队列，https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 * @author: sawyer
 * @create: 2020-02-08 17:35
 **/
public class Solution {

    // 贪心
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }

        return list.toArray(people);
    }
}
