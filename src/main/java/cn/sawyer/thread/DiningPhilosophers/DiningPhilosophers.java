package cn.sawyer.thread.DiningPhilosophers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-13 15:18
 **/

// 解法1，每次允许一个人吃。
class DiningPhilosophers {

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
            pickLeftFork.run();
            pickRightFork.run();
            System.out.println(philosopher + "eat...");
            eat.run();
            putLeftFork.run();
            putRightFork.run();
        }
    }

}