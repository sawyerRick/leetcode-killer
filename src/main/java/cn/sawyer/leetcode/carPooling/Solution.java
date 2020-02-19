package cn.sawyer.leetcode.carPooling;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 拼车，https://leetcode-cn.com/problems/car-pooling/
 * @author: sawyer
 * @create: 2020-02-19 13:30
 **/
public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        Arrays.sort(trips, (a, b) -> a[1] - b[1]);

        // 保存x，y  :  x站下y人
        Queue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getKey().compareTo(b.getKey()));
        int curr = 0;
        for (int i = 0; i < trips.length; i++) {
            // 到站下车
            if (!minHeap.isEmpty()) {
                System.out.println(minHeap.peek().getKey() + ", " + trips[i][1]);
            }
            while (!minHeap.isEmpty() && minHeap.peek().getKey() <= trips[i][1]) {
                curr -= minHeap.poll().getValue();
            }

            // 上车
            minHeap.add(new Pair<>(trips[i][2], trips[i][0]));
            curr += trips[i][0];
            if (curr > capacity) {
                return false;
            }
        }

        return true;
    }
}