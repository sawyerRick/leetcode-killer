package cn.sawyer.leetcodeThread.DiningPhilosophers;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-13 15:18
 **/
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
            eat.run();
            putLeftFork.run();
            putRightFork.run();
        }
    }
}