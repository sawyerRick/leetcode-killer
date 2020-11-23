package cn.sawyer.sort;

/**
 * @program: LeetCode
 * @description: 堆，堆可以用数组来表示，这是因为堆是完全二叉树，而完全二叉树很容易就存储在数组中。
 * @author: sawyer
 * @create: 2020-02-10 22:52
 **/

// Java的优先队列PriorityQueue，用堆实现

// 堆可以用数组表示，数组下标从1开始，k节点 k/2是父节点，2k是左孩子，2k+1是右孩子
public class Heap<T extends Comparable<T>> {

    private T[] heap;
    private int N = 0;

    // 从数组顶端删除最大的元素，并将数组的最后一个元素放到顶端，并让这个元素下沉到合适的位置。
    public T delMax() {
        T max = heap[1];
        swap(1, N--);
        heap[N + 1] = null;
        sink(1);
        return max;
    }

    public void insert(T v) {
        heap[++N] = v;
        swim(N);
    }

    private void swim(int k) {
        // 父节点k/2小于k，上浮
        while (k > 1 && less(k / 2, k)) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    // k比父节点小，下沉到较大的孩子。
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            // 找出较大的孩子
            if (j < N && less(j, j + 1))
                j++;
            // 父节点小，下沉
            if (!less(k, j))
                break;
            swap(k, j);
            k = j;
        }
    }

    public Heap(int maxN) {
        this.heap = (T[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private void swap(int i, int j) {
        T t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }
}