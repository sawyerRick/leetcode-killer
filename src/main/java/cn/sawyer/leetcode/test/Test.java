package cn.sawyer.leetcode.test;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2019-12-17 19:30
 **/
public class Test {
    public static void main(String[] args) {
        try {
            System.out.println(InetAddress.getLocalHost());
            System.out.println(InetAddress.getLoopbackAddress());
            System.out.println(Inet4Address.getLocalHost().getHostAddress());
            System.out.println(InetAddress.getByName("coksk.cn").getHostAddress());
            System.out.println(InetAddress.getByName("spring.io"));
            URL url = new URL("http://coksk.cn");
            System.out.println(url.getHost());
            System.out.println(url.getProtocol());
            URLConnection connection = url.openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            int count = 0;
            while (scanner.hasNextLine()) {
                count++;
                System.out.println(scanner.nextLine());
            }
            System.out.println("count = " + count);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
