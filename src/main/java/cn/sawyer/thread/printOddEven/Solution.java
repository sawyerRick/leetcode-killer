package cn.sawyer.thread.printOddEven;

/**
 * @program: LeetCode
 * @description: 交替打印奇偶数
 * @author: sawyer
 * @create: 2020-03-17 10:43
 **/
public class Solution {

    public static final int TIMES = 50;
    volatile static int num = 0;
    static volatile boolean t1Fin = false;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < TIMES; i++) {
                while (t1Fin) {

                }
                System.out.println(num++ + "," + Thread.currentThread().getName());
                t1Fin = true;
            }
        });


        Thread t2 = new Thread(() -> {
            for (int i = 0; i < TIMES; i++) {
                while (!t1Fin) {

                }
                System.out.println(num++ + "," + Thread.currentThread().getName());
                t1Fin = false;
            }
        });
        t1.start();
        t2.start();
    }
}
