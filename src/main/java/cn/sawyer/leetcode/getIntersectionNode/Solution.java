package cn.sawyer.leetcode.getIntersectionNode;

/**
 * @program: LeetCode
 * @description: 相交链表 url:https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @author: sawyer
 * @create: 2019-12-28 13:53
 **/
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}