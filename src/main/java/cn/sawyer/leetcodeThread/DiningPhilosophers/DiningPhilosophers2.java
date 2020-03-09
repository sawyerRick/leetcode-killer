package cn.sawyer.leetcodeThread.DiningPhilosophers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-19 22:41
 **/


// 解法2：添加一个服务员，服务员说你可以吃了才可以吃。
public class DiningPhilosophers2 {

    public static ReentrantLock[] locks = new ReentrantLock[5];

    public DiningPhilosophers2() {
        for (int i = 0; i < locks.length; i++) {
            locks[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        ReentrantLock forkLeft = philosopher == 0 ? locks[4] : locks[philosopher - 1];
        ReentrantLock forkRight = locks[philosopher];

        try {
            forkLeft.tryLock(100, TimeUnit.NANOSECONDS);
            forkRight.tryLock(100, TimeUnit.NANOSECONDS);
            pickLeftFork.run();
            pickRightFork.run();
            putLeftFork.run();
            putRightFork.run();
        } finally {
            forkLeft.unlock();
            forkRight.unlock();
        }
    }
}
