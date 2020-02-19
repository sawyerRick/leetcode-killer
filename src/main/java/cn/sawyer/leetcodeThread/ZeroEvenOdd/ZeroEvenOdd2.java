package cn.sawyer.leetcodeThread.ZeroEvenOdd;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @program: LeetCode
 * @description: 信号量实现
 * @author: sawyer
 * @create: 2020-02-13 19:46
 **/
public class ZeroEvenOdd2 {

    private int n;


    Semaphore z = new Semaphore(1);
    Semaphore e = new Semaphore(0);
    Semaphore o = new Semaphore(0);


    public ZeroEvenOdd2(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            z.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                o.release();
            } else {
                e.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            e.acquire();
            printNumber.accept(i);
            z.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            o.acquire();
            printNumber.accept(i);
            z.release();
        }
    }
}
