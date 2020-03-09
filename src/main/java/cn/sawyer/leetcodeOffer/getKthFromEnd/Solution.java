package cn.sawyer.leetcodeOffer.getKthFromEnd;

import cn.sawyer.leetcode.link.ListNode;

/**
 * @program: LeetCode
 * @description: 链表倒数第K个，https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * @author: sawyer
 * @create: 2020-02-27 13:36
 **/
public class Solution {

    // 快慢指针
    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }


        // 遍历
    public ListNode getKthFromEnd2(ListNode head, int k) {

        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        curr = head;
        int i = 1;
        while (curr != null) {
            if (i == len - k + 1) {
                return curr;
            }
            curr = curr.next;
            i++;
        }


        return null;
    }
}