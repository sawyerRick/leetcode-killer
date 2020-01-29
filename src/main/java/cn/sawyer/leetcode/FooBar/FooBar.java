package cn.sawyer.leetcode.FooBar;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2019-12-17 18:52
 **/
class FooBar {
    private int n;

    private Object lock = new Object();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.

            synchronized (lock) {
                lock.notify();
                printFoo.run();
                lock.wait();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            synchronized (lock) {
                lock.wait();
                printBar.run();
                lock.notify();
            }
        }
    }
}
