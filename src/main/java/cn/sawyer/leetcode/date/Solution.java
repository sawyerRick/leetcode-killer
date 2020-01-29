package cn.sawyer.leetcode.date;

import java.util.Calendar;
import java.util.Date;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2019-12-09 12:10
 **/
public class Solution {
    public static void main(String[] args) {
        Date date = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.set(1998, Calendar.SEPTEMBER, 24);
        System.out.println(date.getTime());
        System.out.println(calendar.getTime());

        System.out.println(date.getTime());
        System.out.println(calendar.getTime().getTime());
        System.out.println((date.getTime() - calendar.getTime().getTime()) / 1000 / 24 / 60 / 60);

    }
}
