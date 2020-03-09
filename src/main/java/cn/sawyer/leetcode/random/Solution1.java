package cn.sawyer.leetcode.random;

import cn.sawyer.leetcode.link.ListNode;

import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-23 15:21
 **/
public class Solution1 {

    ListNode head;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution1(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int ans = head.val;
        ListNode cur = head.next;
        while (cur != null) {

            cur = cur.next;
        }

        return 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */