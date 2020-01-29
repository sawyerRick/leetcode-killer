package cn.sawyer.leetcode.lruCache;

import java.util.Hashtable;

/**
 * @program: LeetCode
 * @description: 双向链表+哈希表实现LRU缓存机制（页面置换算法之一） url: https://leetcode-cn.com/problems/lru-cache/submissions/
 * @author: sawyer
 * @create: 2019-12-29 13:37
 **/

public class LRUCache {

    // 双向链表，方便操作
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    // 双向链表 添加节点很简单
    private void addNode(DLinkedNode node) {
        /**
         * Always add the new node right after head.
         */
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    // 双向链表 删除节点很简单
    private void removeNode(DLinkedNode node){

        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLinkedNode node){
        /**
         * Move certain node in between to the head.
         */
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        /**
         * Pop the current tail.
         */
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    // 保存key, Node对应关系的哈希表，不关心具体结构，只存具体数据。
    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    // 双向链表的头尾空节点，方便操作
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        // head.prev = null;

        tail = new DLinkedNode();
        // tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;

        // move the accessed node to the head;
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if(node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            ++size;

            if(size > capacity) {
                // pop the tail
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            // update the value.
            node.value = value;
            moveToHead(node);
        }
    }
}
