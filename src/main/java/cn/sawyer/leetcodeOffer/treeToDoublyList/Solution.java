package cn.sawyer.leetcodeOffer.treeToDoublyList;

/**
 * @program: LeetCode
 * @description: 二叉搜索树转换双向链表，https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * @author: sawyer
 * @create: 2020-02-16 00:59
 **/

// 思路，中序遍历，保存前一个，指向当前
public class Solution {

    Node pre;

    private void dfs(Node cur) {
        if (cur == null) {
            return;
        }

        dfs(cur.left);

        cur.left = pre;
        if (pre != null) {
            pre.right = cur;
        }
        pre = cur;

        dfs(cur.right);
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        dfs(root);

        // 连接头尾
        Node tail = root;
        Node head = root;

        while (tail.right != null) {
            tail = tail.right;
        }

        while (head.left != null) {
            head = head.left;
        }

        tail.right = head;
        head.left = tail;

        return head;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};