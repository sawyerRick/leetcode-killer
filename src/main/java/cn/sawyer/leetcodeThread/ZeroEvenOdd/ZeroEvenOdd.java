package cn.sawyer.leetcodeThread.ZeroEvenOdd;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @program: LeetCode
 * @description: 打印零奇偶数，https://leetcode-cn.com/problems/print-zero-even-odd/
 * @author: sawyer
 * @create: 2020-02-13 19:24
 **/

// 状态实现
public class ZeroEvenOdd {
    private int n;

    volatile int flag = 0;

//    Semaphore z = new Semaphore(0);
//    Semaphore e = new Semaphore(1);
//    Semaphore o = new Semaphore(1);


    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (flag != 0) {
                Thread.yield();
            }
            printNumber.accept(0);
            flag = i % 2 == 0 ? 1: 2;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {

            while (flag != 2) {
                Thread.yield();
            }
            printNumber.accept(i);
            flag = 0;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (flag != 1) {
                Thread.yield();
            }
            printNumber.accept(i);
            flag = 0;
        }
    }
}
