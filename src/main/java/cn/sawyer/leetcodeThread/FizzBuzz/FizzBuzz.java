package cn.sawyer.leetcodeThread.FizzBuzz;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @program: LeetCode
 * @description: 交替打印字符串，https://leetcode-cn.com/problems/fizz-buzz-multithreaded/
 * @author: sawyer
 * @create: 2020-02-13 20:24
 **/


class FizzBuzz {
    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    Semaphore f = new Semaphore(0);
    Semaphore b = new Semaphore(0);
    Semaphore fb = new Semaphore(0);

    volatile boolean fin;

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (!fin) {
            f.acquire();
            if (!fin) {
                printFizz.run();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (!fin) {
            b.acquire();
            if (!fin) {
                printBuzz.run();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (!fin) {
            fb.acquire();
            if (!fin) {
                printFizzBuzz.run();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                // bizzbuzz
                fb.release();
            } else if (i % 5 == 0) {
                // buzz
                b.release();
            } else if (i % 3 == 0) {
                // fizz
                f.release();
            } else {
                // num
                printNumber.accept(i);
            }
        }
        fin = true;
        fb.release();
        f.release();
        b.release();
    }
}