package cn.sawyer.leetcodeOffer.copyRandomList;

import java.util.HashMap;

/**
 * @program: LeetCode
 * @description: 复杂链表的复制，https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * @author: sawyer
 * @create: 2020-02-15 16:51
 **/
public class Solution {
    HashMap<Node, Node> visitedHash = new HashMap<>();

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }

        Node node = new Node(head.val, null, null);

        this.visitedHash.put(head, node);

        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);

        return node;
    }
}

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
