package interview.tencent.practice;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 腾讯2020校园招聘-后台 企业提供原题第四题
 * @author: sawyer
 * @create: 2020-04-26 16:06
 **/

/**
 * 题目：
 * 由于业绩优秀，公司给小Q放了 n 天的假，身为工作狂的小Q打算在在假期中工作、锻炼或者休息。他有个奇怪的习惯：不会连续两天工作或锻炼。只有当公司营业时，小Q才能去工作，只有当健身房营业时，小Q才能去健身，小Q一天只能干一件事。给出假期中公司，健身房的营业情况，求小Q最少需要休息几天。
 *
 * 输入描述:
 * 第一行一个整数  表示放假天数
 * 第二行 n 个数 每个数为0或1,第 i 个数表示公司在第 i 天是否营业
 * 第三行 n 个数 每个数为0或1,第 i 个数表示健身房在第 i 天是否营业
 * （1为营业 0为不营业）
 *
 * 输出描述:
 * 一个整数，表示小Q休息的最少天数
 *
 * 输入例子1:
 * 4
 * 1 1 0 0
 * 0 1 1 0
 *
 * 输出例子1:
 * 2
 *
 * 例子说明1:
 * 小Q可以在第一天工作，第二天或第三天健身，小Q最少休息2天
 */

/**
 * 思路：dp[i][0] , dp[i][1], dp[i][2] 分别记录第i天 休息/锻炼/工作 累计的最小休息天数
 * 选择健身，值为前一天休息和工作的最大值+1。
 * 选择工作，值为前一天休息和健身的最大值+1。
 * 休息无事可做，值为前一天3中状态下的最大值。
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] gym=new int[n];
        int[] work=new int[n];
        for(int i=0;i<n;i++) {
            work[i]=in.nextInt();
        }
        for(int i=0;i<n;i++) {
            gym[i]=in.nextInt();
        }
        // dp[i][j] 记录第i天 j是休息/锻炼/工作 累计的最小休息天数
        int[][] dp=new int[n+1][3];     // 0：休息   1：锻炼     2：工作
        // 关键，初始化为无穷大避免误判
        for (int i = 1; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for(int i=1;i<=n;i++) {
            // 可以锻炼
            if(gym[i-1]==1) {
                dp[i][1]=Math.min(dp[i-1][0], dp[i-1][2]);
            }
            // 可以工作
            if(work[i-1]==1) {
                dp[i][2]=Math.min(dp[i-1][0], dp[i-1][1]);
            }
            // 可以休息，休息天数 + 1
            dp[i][0] = Math.min(dp[i-1][0], Math.min(dp[i-1][1], dp[i-1][2])) + 1;
        }
        int res = Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
        System.out.println(res);
    }
}