package cn.sawyer.leetcodeThread.FooBar;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LeetCode
 * @description: 第四种方法
 * @author: sawyer
 * @create: 2020-02-13 18:31
 **/
// 用循环屏障解决
public class FooBar4 {

    private int n;

    CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    private boolean fin;

    public FooBar4(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            printFoo.run();
            fin = true;
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // 自旋
            while (!fin) {

            }

            printBar.run();
            fin = false;
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
            }
        }
    }
}
