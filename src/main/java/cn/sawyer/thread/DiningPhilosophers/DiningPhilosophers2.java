package cn.sawyer.thread.DiningPhilosophers;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-19 22:41
 **/

// 解法2：四个哲学家一起抢，但是只有拿到两把叉子才可以吃
public class DiningPhilosophers2 {

    private Lock[] locks = {
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock()};
    Semaphore semaphore = new Semaphore(4);

    public DiningPhilosophers2() {
    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        Lock forkLeft = locks[philosopher];
        Lock forkRight = locks[(philosopher + 1) % 5];

        try {
            semaphore.acquire();
            while (!forkLeft.tryLock()) {
                Thread.yield();
            }
            while (!forkRight.tryLock()) {
                Thread.yield();
            }
            pickLeftFork.run();
            pickRightFork.run();
            System.out.println(philosopher + " eat..");
            eat.run();
            putLeftFork.run();
            putRightFork.run();
            semaphore.release();
        } finally {
            try {
                forkLeft.unlock();
                forkRight.unlock();
            } catch (Exception e) {

            }
        }
    }
}
