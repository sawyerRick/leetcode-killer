package cn.sawyer.leetcodeThread.H2O;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @program: LeetCode
 * @description: 生成H2O
 * @author: sawyer
 * @create: 2020-02-13 19:57
 **/
class H2O {

    Semaphore h = new Semaphore(2);
    Semaphore o = new Semaphore(0);


    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        releaseHydrogen.run();
        o.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(2);
        releaseOxygen.run();
        h.release(2);
    }
}