package cn.sawyer.leetcode.lruCache;

import java.util.HashMap;

/**
 * @program: LeetCode
 * @description: 自己写一遍
 * @author: sawyer
 * @create: 2019-12-30 12:37
 **/

// 用双向链表+哈希表实现LRU缓存算法。
public class MyLRUCache {

    class DLink{
        DLink prev;
        DLink next;

        int key;
        int value;

        @Override
        public String toString() {
            return "DLink{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private DLink head;
    private DLink tail;
    private HashMap<Integer, DLink> map;

    int size;
    int capacity;

    private void moveToHead(DLink node) {
//        System.out.println("move :" + node + " to head");
        remove(node);
        DLink next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
        map.put(node.key, node);
    }

    private void remove(DLink node) {
//        System.out.println("remove node:" + tail.prev);
        map.remove(node.key);
        DLink next = node.next;
        DLink prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }


    public MyLRUCache(int capacity) {
        map = new HashMap<>();
        head = new DLink();
        tail = new DLink();
        this.capacity = capacity;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLink node = map.get(key);
        if (node == null) {
            return -1;
        }

        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLink node = map.get((key));
            node.value = value;
            moveToHead(node);
        } else {

            if (size >= capacity) {
//            System.out.println("remove node :" + tail.prev);
                remove(tail.prev);
                size--;
            }

            DLink node = new DLink();
            node.key = key;
            node.value = value;
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
            moveToHead(node);
            size++;
        }
    }

    public static void main(String[] args) {
//        [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
        MyLRUCache myLRUCache = new MyLRUCache(2);
        System.out.println(myLRUCache.get(2));
        myLRUCache.put(2, 6);
        System.out.println(myLRUCache.get(1));
        myLRUCache.put(1, 5);
        myLRUCache.put(1, 2);
        System.out.println(myLRUCache.get(1));
        System.out.println(myLRUCache.get(2));
    }
}
