package cn.sawyer.leetcode.lruCache.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: FIFO 缓存
 * @author: sawyer
 * @create: 2020-03-16 18:55
 **/
public class FIFOCache {

    class Node {
        int key;
        int val;

        Node next;
        Node pre;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    Node head;
    Node tail;
    int size;
    int capacity;

    private void addToTail(Node node) {
        node.next = tail;
        Node tailPrev = tail.pre;
        tailPrev.next = node;
        node.pre = tailPrev;
        tail.pre = node;
    }

    private int removeFromHead() {
        Node toBeRm = head.next;
        toBeRm.next.pre = head;
        head.next = toBeRm.next;
        return toBeRm.key;
    }

    FIFOCache (int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0 ,0);
        head.next = tail;
        tail.pre = head;
    }

    public void put(int key, int val) {

        if (map.containsKey(key)) {
            Node curr = map.get(key);
            curr.val = val;
            map.put(key, curr);
        } else {
            // 添加
            Node newNode = new Node(key, val);
            addToTail(newNode);
            map.put(key, newNode);
            size++;

            if (size > capacity) {
                System.out.println("rm");
                int rmKey = removeFromHead();
                map.remove(rmKey);
                size--;
            }
        }

        Node cu = head;
        while (cu != null) {
            System.out.print(cu.val + " ");
            cu = cu.next;
        }
        System.out.println();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node curr = map.get(key);

        return curr.val;
    }

    public static void main(String[] args) {
        FIFOCache cache = new FIFOCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
//        cache.put(4, 4);
//        cache.put(5, 5);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }
}
