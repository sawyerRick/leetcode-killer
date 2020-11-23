package interview.tencent.practice;

/**
 * @program: LeetCode
 * @description: 视野争夺
 * @author: sawyer
 * @create: 2020-04-26 16:14
 **/

/**
 * 题目：
 * 小Q在进行一场竞技游戏,这场游戏的胜负关键就在于能否能争夺一条长度为L的河道,即可以看作是[0,L]的一条数轴。
 * 这款竞技游戏当中有n个可以提供视野的道具−真视守卫,第i个真视守卫能够覆盖区间[xi,yi]。现在小Q想知道至少用几个真视守卫就可以覆盖整段河道。
 *
 * 输入描述:
 * 输入包括n+1行。
 *
 * 第一行包括两个正整数n和L(1<=n<=105,1<=L<=109)
 *
 * 接下来的n行,每行两个正整数xi,yi(0<=xi<=yi<=109),表示第i个真视守卫覆盖的区间。
 *
 *
 * 输出描述:
 * 一个整数，表示最少需要的真视守卫数量, 如果无解, 输出-1。
 *
 * 输入例子1:
 * 4 6
 * 3 6
 * 2 4
 * 0 2
 * 4 7
 *
 * 输出例子1:
 * 3
 */

/**
 * 思路：根据左边界排序，从点[0, y]开始每次选择一个左边界x在[0,y]之间并且右边界最大的点，依次类推获取到最优解。
 */

import java.util.*;

public class Main5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        // 根据左边界排序的优先队列
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1]: o1[0] - o2[0]);
        for (int i = 0; i < n; i++) {
            int[] arr = new int[2];
            arr[0] = scanner.nextInt();
            arr[1] = scanner.nextInt();
            queue.add(arr);
        }
        scanner.close();

        // 最小区间起点不为0，报错
        if (queue.peek()[0] != 0) {
            System.out.println(-1);
        } else {
            // 记录右边界
            int from = queue.remove()[1];
            int count = 1;
            // 根据右边界排序的优先队列
            PriorityQueue<int[]> queue1 = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
            while (from < l) {
                // 找出左边界小于等于from的
                while (!queue.isEmpty() && queue.peek()[0] <= from)
                    queue1.add(queue.poll());
                // 找出最大的右边界的点
                if (!queue1.isEmpty() && queue1.peek()[1] > from) {
                    // 更新右边界
                    from = queue1.poll()[1];
                    count++;
                } else {
                    System.out.println(-1);
                    return;
                }
            }
            System.out.println(count);
        }
    }
}
