package cn.sawyer.leetcode.kthSmallest;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 有序矩阵中第k个小的元素，https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * @author: sawyer
 * @create: 2020-02-22 12:54
 **/
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        Queue<Integer> maxHeap = new PriorityQueue<>(k + 1, (a, b) -> b - a);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                maxHeap.add(matrix[i][j]);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }


        return maxHeap.peek();
    }
}