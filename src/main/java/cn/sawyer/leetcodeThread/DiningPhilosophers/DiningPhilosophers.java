package cn.sawyer.leetcodeThread.DiningPhilosophers;

import java.io.ObjectOutputStream;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-13 15:18
 **/

// 解法1，只有同时拿到两把叉子，才开始吃。
class DiningPhilosophers {

    public static ReentrantLock[] locks = new ReentrantLock[] {new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock() };


    public DiningPhilosophers() {
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        synchronized (DiningPhilosophers.class) {
            ReentrantLock forkLeft = philosopher == 0 ? locks[4] : locks[philosopher - 1];
            ReentrantLock forkRight = locks[philosopher];

            try {
                forkLeft.tryLock(100, TimeUnit.NANOSECONDS);
                forkRight.tryLock(100, TimeUnit.NANOSECONDS);
                pickLeftFork.run();
                pickRightFork.run();
                eat.run();
                putLeftFork.run();
                putRightFork.run();
            } finally {
                forkLeft.unlock();
                forkRight.unlock();
            }
        }
    }

}