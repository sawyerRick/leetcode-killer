package cn.sawyer.leetcodeOffer.reversePrint;

import cn.sawyer.leetcode.link.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * @program: LeetCode
 * @description: 从尾到头打印链表，https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * @author: sawyer
 * @create: 2020-02-12 19:29
 **/
public class Solution {

    public int[] reversePrint(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] ans = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pop();
        }

        return ans;
    }
}
