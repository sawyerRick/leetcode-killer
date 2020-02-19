package cn.sawyer.leetcodeThread.FooBar;

/**
 * @program: LeetCode
 * @description: 交替打印FootBar，https://leetcode-cn.com/problems/print-foobar-alternately/
 * @author: sawyer
 * @create: 2020-02-13 15:29
 **/


// 用wait()和notify()来做。
class FooBar {
    private int n;

    private boolean fooFinished;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                if (fooFinished) {
                    this.wait();
                }
                printFoo.run();
                this.notify();
                fooFinished = true;
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                if (!fooFinished) {
                    this.wait();
                }
                printBar.run();
                fooFinished = false;
                this.notify();
            }
        }
    }
}