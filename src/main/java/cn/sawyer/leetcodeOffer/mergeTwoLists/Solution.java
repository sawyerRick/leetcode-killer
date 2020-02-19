package cn.sawyer.leetcodeOffer.mergeTwoLists;

import cn.sawyer.leetcode.link.ListNode;

/**
 * @program: LeetCode
 * @description: 合并两个排序的链表，https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * @author: sawyer
 * @create: 2020-02-13 12:12
 **/
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode curr = new ListNode(0);
        ListNode head = curr;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                curr.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curr = curr.next;
        }

        while (l2 != null) {
            curr.next = new ListNode(l2.val);
            l2 = l2.next;
            curr = curr.next;
        }

        while (l1 != null) {
            curr.next = new ListNode(l1.val);
            l1 = l1.next;
            curr = curr.next;
        }

        return head.next;
    }
}
