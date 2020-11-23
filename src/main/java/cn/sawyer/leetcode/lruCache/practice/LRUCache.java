package cn.sawyer.leetcode.lruCache.practice;


import java.util.HashMap;

/**
 * @program: LeetCode
 * @description: 先进先出缓存
 * @author: sawyer
 * @create: 2020-03-16 18:18
 **/

public class LRUCache {

    class Node {
        int key;
        int val;

        Node pre;
        Node next;
    }

    HashMap<Integer, Node> map = new HashMap<>();
    Node head;
    Node tail;
    int capacity;
    int size;

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(Node node) {
        head.next.pre = node;
        node.next = head.next;

        head.next = node;
        node.pre = head;
    }

    private void removeNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;
    }

    LRUCache(int capacity) {
        this.capacity = capacity;

        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }
    // 修改/添加
    public void put(int key, int val) {
        System.out.println(key + ", " + val + " " + size + ", " + capacity);
        // 修改
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            map.put(key, curr);
            curr.val = val;
            moveToHead(curr);
        } else {
            // 添加

            Node node = new Node();
            node.key = key;
            node.val = val;
            map.put(key, node);
            addToHead(node);
            size++;

            // 淘汰
            if (size > capacity) {
                map.remove(tail.pre.key);
                removeNode(tail.pre);
                size--;
            }

        }
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node curr = map.get(key);
        moveToHead(curr);
        int ans = curr.val;


        return ans;
    }

}
