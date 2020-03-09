package cn.sawyer.leetcodeOffer;

import cn.sawyer.leetcode.link.ListNode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: LeetCode
 * @description: 两个链表的第一个公共节点，https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * @author: sawyer
 * @create: 2020-02-27 12:12
 **/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> set = new HashSet<>();
        ListNode curr = headA;
        while (curr != null) {
            set.add(curr);
            curr = curr.next;
        }
        curr = headB;
        while (curr != null) {
            if (set.contains(curr)) {
                return curr;
            }
            curr = curr.next;
        }


        return null;
    }
}