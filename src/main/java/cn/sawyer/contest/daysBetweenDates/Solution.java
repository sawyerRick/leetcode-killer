package cn.sawyer.contest.daysBetweenDates;


import java.nio.channels.SocketChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-23 10:30
 **/
public class Solution {

    public int daysBetweenDates(String date1, String date2) {


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(date1);
            d2 = format.parse(date2);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(d1);
        System.out.println(d2);
        int a = (int) ((d1.getTime() - d2.getTime()) / (1000*3600*24));

        return Math.abs(a);
    }
}