package cn.sawyer.leetcode.sortList;


import cn.sawyer.leetcode.link.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 链表排序 url:https://leetcode-cn.com/problems/sort-list/
 * @author: sawyer
 * @create: 2019-12-29 13:21
 **/
public class Solution {
    public ListNode sortList(ListNode head) {
        ListNode node = head;
        List<Integer> list = new ArrayList<>();

        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        Collections.sort(list);
        node = head;
        for (Integer integer : list) {
            node.val = integer;
            node = node.next;
        }

        return head;
    }
}