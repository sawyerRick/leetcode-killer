package cn.sawyer.leetcode.hasCycle;


import cn.sawyer.leetcode.link.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: LeetCode
 * @description: 判断链表有环，url:https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode/
 * @author: sawyer
 * @create: 2019-12-27 20:32
 **/
public class Solution {
    // 判断链表有环，返回入环的第一个节点，url:https://leetcode-cn.com/problems/linked-list-cycle-ii/
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            nodeSet.add(head);
            head = head.next;
            if (nodeSet.contains(head)) {
                return head;
            }
        }

        return null;
    }

    // 佛洛依德算法，2d = d
    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean hasCycle = false;

        // 判断有环
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }

        // 找出入口
        if (hasCycle) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        }

        return null;
    }


    // 哈希法
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            nodes.add(node);
            node = node.next;
            if (nodes.contains(node)) {
                return true;
            }
        }

        return false;
    }


    // 双指针法
    // 原理 在圆形跑道中，跑得快的一定会追上跑得慢的
    public boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}