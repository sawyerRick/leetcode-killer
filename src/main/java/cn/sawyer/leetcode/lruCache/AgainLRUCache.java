package cn.sawyer.leetcode.lruCache;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 再写一遍
 * @author: sawyer
 * @create: 2020-02-19 21:25
 **/
public class AgainLRUCache {

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    int size;

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void add(Node node) {
        head.next.prev = node;
        node.next = head.next;

        head.next = node;
        node.prev = head;
    }

    private void move2Head(Node node) {
        remove(node);
        add(node);
    }

    public AgainLRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if (map.containsKey(key)) {
            move2Head(map.get(key));
            return map.get(key).val;
        }

        return -1;
    }

    public void put(int key, int value) {
        // 添加/修改
        if (map.containsKey(key)) {
            // 修改
            map.get(key).val = value;
            move2Head(map.get(key));
        } else {
            // 添加
            Node newNode = new Node(key, value);
            add(newNode);
            map.put(key, newNode);
            size++;
            // 删除LRU
            if (size > capacity) {
                Node last = tail.prev;
                map.remove(last.key);
                remove(last);
                size--;
            }
        }
    }
}
