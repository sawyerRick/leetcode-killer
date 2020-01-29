package cn.sawyer.leetcode.mergeKLists;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2019-12-17 16:03
 **/
// 合并k个有序表
public class Solution {
    // 合并两个有序表
    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode newList = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                newList.next = new ListNode(l1.val);
                newList = newList.next;
                l1 = l1.next;
            } else {
                newList.next = new ListNode(l2.val);
                newList = newList.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            newList.next = new ListNode(l1.val);
            newList = newList.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            newList.next = new ListNode(l2.val);
            newList = newList.next;
            l2 = l2.next;
        }

        return head.next;
    }

    // 用两两合并的方法解决
    public ListNode mergeKListsBy2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length < 2) {
            return lists[0];
        }
        ListNode head = merge2Lists(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            head = merge2Lists(lists[i], head);
        }

        return head;
    }


    // 暴力法 化为列表，排序，再化为链表
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int i = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (ListNode head : lists) {
            ListNode node = head;
            while (node != null) {
                list.add(node.val);
                System.out.println(node.val);
                node = node.next;
            }
        }

        if (list.size() == 0) {
            return null;
        }

        Collections.sort(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        ListNode head = new ListNode(list.get(0));
        ListNode node = head;
        for (int j = 1; j < list.size(); j++) {
            node.next = new ListNode(list.get(j));
            node = node.next;
        }

        return head;
    }



}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}