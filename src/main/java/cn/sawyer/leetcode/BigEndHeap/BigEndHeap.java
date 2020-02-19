package cn.sawyer.leetcode.BigEndHeap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 大顶堆，优先队列
 * @author: sawyer
 * @create: 2020-02-05 01:28
 **/
public class BigEndHeap {

    Heap heap;

    class Heap {
        int val;
        Heap left;
        Heap right;
        Heap parent;

        public Heap(int val) {
            Queue q = new PriorityQueue();
            this.val = val;
        }
    }

    public void add(Integer element) {
        if (heap == null) {
            heap = new Heap(element);
        }
    }

    public Integer pop() {
        return 1;
    }

    public static void main(String[] args) {
        BigEndHeap bigEndHeap = new BigEndHeap();
    }
}
