package cn.sawyer.leetcode.removeNthFromEnd;

import cn.sawyer.leetcode.link.ListNode;

/**
 * @program: LeetCode
 * @description: 删除链表的倒数第n个节点 url :https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @author: sawyer
 * @create: 2020-01-03 16:34
 **/
public class Solution {
    // 两次遍历法
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int len = 0;

        while (head != null) {
            head = head.next;
            len++;
        }

        head = dummy;
        len -= n;
        while (len > 0) {
            len--;
            head = head.next;
        }
        head.next = head.next.next;

        return dummy.next;
    }

    // 一次遍历法 双指针
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        int curr = 1;
        while (curr <= n + 1) {
            fast = fast.next;
            curr++;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;


        return dummy.next;
    }
}
