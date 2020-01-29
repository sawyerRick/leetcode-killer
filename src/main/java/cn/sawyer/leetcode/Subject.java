package cn.sawyer.leetcode;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2019-12-29 14:10
 **/
public class Subject {
    // 1~n, m个翻转一次
    public static int sum(int n, int m) {
        int sum = 0;
        boolean signed = true;
        int counter = 1;

        for (int i = 1; i <= n; i++) {
            sum = signed ? sum - i : sum + i;
            if (counter == m) {
                counter = 1;
                signed = !signed;
            } else {
                counter++;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum(100, 1));
    }
}
