package cn.sawyer.leetcodeOffer.MaxQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-07 14:49
 **/
// 再写一遍
public class MaxQueue2 {

    Queue<Integer> queue = new LinkedList<>();
    Deque<Integer> deque = new ArrayDeque<>();

    void clean(int newVal) {
        while (!deque.isEmpty() && deque.getLast() < newVal) {
            deque.removeLast();
        }
        deque.addLast(newVal);
    }

    public MaxQueue2() {

    }

    public int max_value() {
        if (deque.isEmpty()) {
            return -1;
        }

        return deque.getFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        clean(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int ans = queue.poll();

        if (ans == deque.getFirst()) {
            deque.pollFirst();
        }

        return ans;
    }
}
