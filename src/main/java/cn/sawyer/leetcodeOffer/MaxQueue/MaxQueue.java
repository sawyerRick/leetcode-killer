package cn.sawyer.leetcodeOffer.MaxQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 队列的最大值，https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 * @author: sawyer
 * @create: 2020-02-13 11:23
 **/

/*
1. 用一个队列保存正常元素，另一个双向队列保存单调递减的元素
2. 入栈时，第一个队列正常入栈；第二个队列是递减队列，所以需要与之前的比较，从尾部把小于当前value的全部删除（因为用不到了）
3. 出栈时，第一个队列正常出栈；第二个队列的头部与出栈的值作比较，如果相同，那么一起出栈
 */
class MaxQueue {

    // 1.
    Queue<Integer> queue = new LinkedList<>();
    Deque<Integer> dq = new ArrayDeque<>();

    public MaxQueue() {

    }

    public int max_value() {

        if (!dq.isEmpty()) {
            return dq.getFirst();
        }
        return -1;
    }

    public void push_back(int value) {
        queue.add(value);
        // 2.
        while (!dq.isEmpty() && dq.getLast() < value) {
            dq.removeLast();
        }
        dq.addLast(value);
    }

    public int pop_front() {

        //3.
        if (!queue.isEmpty() && !dq.isEmpty()) {
            // 相同
            if (queue.peek().equals(dq.getFirst())) {
                dq.removeFirst();
            }
            return queue.poll();
        }
        return -1;
    }
}