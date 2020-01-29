package cn.sawyer.leetcode.link.isPalindrome;

import cn.sawyer.leetcode.link.ListNode;

/**
 * @program: LeetCode
 * @description: 判断回文
 * @author: sawyer
 * @create: 2020-01-10 13:58
 **/

// 快慢指针法找中点，翻转前半段链表，分别遍历两半检查是否相等
public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        ListNode prePre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prePre;
            prePre = pre;
        }

        if (fast != null) {
            // 长度为单数
            slow = slow.next;
        }
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }

        return true;
    }
}
