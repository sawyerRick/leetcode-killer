package cn.sawyer.leetcode.reorderList;

import cn.sawyer.leetcode.link.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 重排链表，https://leetcode-cn.com/problems/reorder-list/
 * @author: sawyer
 * @create: 2020-02-21 23:35
 **/


public class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        List<ListNode> nodeList = new ArrayList<>();

        ListNode curr = head;
        while (curr != null) {
            nodeList.add(curr);
            curr = curr.next;
        }
        int l = 0;
        int h = nodeList.size() - 1;
        while (l < h) {
            nodeList.get(l).next = nodeList.get(h);
            l++;
            nodeList.get(h).next = nodeList.get(l);
            h--;
        }

        if (nodeList.size() % 2 == 0) {
            nodeList.get(l + 1).next = null;
        } else {
            nodeList.get(l).next = null;
        }

        return;
    }
}