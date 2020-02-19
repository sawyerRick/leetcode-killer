package cn.sawyer.leetcodeThread.H2O;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @program: LeetCode
 * @description: 用内存屏障+信号量
 * @author: sawyer
 * @create: 2020-02-13 20:18
 **/
public class H2OV2 {

    CyclicBarrier cb = new CyclicBarrier(3);
    Semaphore h = new Semaphore(2);
    Semaphore o = new Semaphore(1);


    public H2OV2() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        releaseHydrogen.run();
        try {
            cb.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        h.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire();
        releaseOxygen.run();
        try {
            cb.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        o.release();
    }
}
