package cn.sawyer.leetcode.addTwoNumbers;

import cn.sawyer.leetcode.link.ListNode;

/**
 * @program: LeetCode
 * @description: 两数相加，https://leetcode-cn.com/problems/add-two-numbers/
 * @author: sawyer
 * @create: 2020-02-06 15:12
 **/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode node = new ListNode(0);
        ListNode head = node;

        int ac = 0;
        while (p1 != null || p2 != null) {
            int i1 = p1 == null ? 0 : p1.val;
            int i2 = p2 == null ? 0 : p2.val;
            int tmp = i1 + i2 + ac;
            ac = tmp / 10;
            node.next = new ListNode(tmp % 10);
            node = node.next;

            p1 = p1 == null ? null : p1.next;
            p2 = p2 == null ? null : p2.next;
        }

        if (ac != 0) {
            node.next = new ListNode(ac);
        }

        return head.next;
    }
}
