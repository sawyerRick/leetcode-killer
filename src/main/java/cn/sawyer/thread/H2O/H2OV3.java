package cn.sawyer.thread.H2O;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-17 10:37
 **/

// 自旋操作
public class H2OV3 {

    public H2OV3() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        releaseHydrogen.run();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
    }
}