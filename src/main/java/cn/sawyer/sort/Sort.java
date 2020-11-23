package cn.sawyer.sort;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-10 19:28
 **/
public abstract class Sort<T extends Comparable<T>> {

    public abstract void sort(T[] nums);

    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    protected void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}