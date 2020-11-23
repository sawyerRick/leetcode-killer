package cn.sawyer.thread.FooBar;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LeetCode
 * @description: 第二种做法
 * @author: sawyer
 * @create: 2020-02-13 17:55
 **/


// 使用RentrantLock
public class FooBar2 {
    private int n;

    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    private boolean fooFinished;

    public FooBar2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            if (fooFinished) {
                condition.await();
            }
            printFoo.run();
            fooFinished = true;
            condition.signal();
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            if (!fooFinished) {
                condition.await();
            }
            printBar.run();
            fooFinished = false;
            condition.signal();
            lock.unlock();
        }
    }
}
