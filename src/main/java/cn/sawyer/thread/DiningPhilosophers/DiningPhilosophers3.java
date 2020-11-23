package cn.sawyer.thread.DiningPhilosophers;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-18 11:39
 **/
class DiningPhilosophers3 {
    private int size = 5;
    private volatile boolean[] forks = new boolean[size];

    private synchronized boolean getForks(int i) {
        //2个叉子都未被使用
        if (!forks[i] && !forks[i == 0 ? size - 1 : i - 1]) {
            forks[i] = true;
            forks[i == 0 ? size - 1 : i - 1] = true;
            return true;
        }
        return false;
    }

    public DiningPhilosophers3() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        while (!getForks(philosopher)){
            Thread.sleep(1);
        }
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        forks[philosopher == 0 ? philosopher + 4 : philosopher - 1] = false;
        putRightFork.run();
        forks[philosopher] = false;
    }

}