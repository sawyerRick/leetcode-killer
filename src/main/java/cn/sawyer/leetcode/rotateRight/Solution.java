package cn.sawyer.leetcode.rotateRight;

import cn.sawyer.leetcode.link.ListNode;

/**
 * @program: LeetCode
 * @description: 右旋链表，url:https://leetcode-cn.com/problems/rotate-list/solution/
 * @author: sawyer
 * @create: 2020-01-02 15:15
 **/
// 先形成环，再找到合适位置切开。
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode node = head;
        int len = 1;

        while (node.next != null) {
            len++;
            node = node.next;
        }

        if (len == k) {
            return head;
        }

        node.next = head;
        int index;

        index = len > k? len - k: len - (k % len);

        ListNode n = head;
        for (int i = 0; i < index - 1; i++) {
            n = n.next;
        }
        head = n.next;
        n.next = null;

        return head;
    }
}
