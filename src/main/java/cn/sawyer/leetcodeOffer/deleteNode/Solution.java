package cn.sawyer.leetcodeOffer.deleteNode;

import cn.sawyer.leetcode.link.ListNode;

/**
 * @program: LeetCode
 * @description: 删除链表节点，https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * @author: sawyer
 * @create: 2020-02-13 11:57
 **/
public class Solution {

    public ListNode deleteNode(ListNode head, int val) {

        ListNode h = new ListNode(0);
        h.next = head;
        ListNode prev = h;
        ListNode curr = h.next;

        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
        }

        return h.next;
    }
}
