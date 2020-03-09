package cn.sawyer.leetcode.mergeKLists;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 用堆解决
 * @author: sawyer
 * @create: 2020-02-22 12:31
 **/
public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        Queue<ListNode> minHeap = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);

        for (ListNode head : lists) {
            if (head != null) {
                minHeap.add(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            if (node.next != null) {
                minHeap.add(node.next);
            }
            curr.next = node;
            curr = curr.next;
        }
        curr.next = null;

        return dummy.next;
    }
}