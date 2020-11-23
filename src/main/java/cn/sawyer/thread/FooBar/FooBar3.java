package cn.sawyer.thread.FooBar;

import java.util.concurrent.CountDownLatch;

/**
 * @program: LeetCode
 * @description: 第三种做法
 * @author: sawyer
 * @create: 2020-02-13 18:06
 **/

// 使用CountDownLatch
public class FooBar3 {

    private int n;

    CountDownLatch latch = new CountDownLatch(1);

    public static CountDownLatch cdl = new CountDownLatch(1);

    public FooBar3(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (latch.getCount() == 0) {

            }
            printFoo.run();
            latch.countDown();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            latch.await();
            printBar.run();
            latch = new CountDownLatch(1);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        cdl.countDown();
        cdl.await();
        System.out.println(cdl.getCount());
        cdl.await();
        System.out.println(cdl.getCount());
        System.out.println(1);
    }
}

