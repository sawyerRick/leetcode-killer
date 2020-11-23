package cn.sawyer.thread.printOddEven;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-17 10:48
 **/
public class Solution2 {

    public static final int TIMES = 50;
    volatile static int num = 0;
    static Object lock = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < TIMES; i++) {
                synchronized(lock) {
                    System.out.println(num++ + "," + Thread.currentThread().getName());
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        Thread t2 = new Thread(() -> {
            for (int i = 0; i < TIMES; i++) {
                synchronized(lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(num++ + "," + Thread.currentThread().getName());
                    lock.notify();
                }
            }
        });
        t1.start();
        t2.start();
    }
}