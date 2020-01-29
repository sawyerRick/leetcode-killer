package cn.sawyer.nowcode.printListFromTailToHead;

import cn.sawyer.leetcode.link.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-01-01 15:58
 **/
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        LinkedList<Integer> ans = new LinkedList<>();
        while (listNode != null) {
            ans.push(listNode.val);
            listNode = listNode.next;
        }

        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        LinkedList<Integer> ans = new LinkedList<>();
        ans.push(1);
        ans.push(2);
        for (Integer an : ans) {
            System.out.println(an);
        }
    }
}
