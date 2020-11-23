package interview.tencent.practice;

/**
 * @program: LeetCode
 * @description: 解压字符串
 * @author: sawyer
 * @create: 2020-04-26 16:29
 **/
import java.util.*;

public class Main1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        scanner.close();
        System.out.println(decode(next));
    }

    // 简单拼接
    public static String decode(String words){
        while (words.contains("]")){
            int right = words.indexOf("]");
            int left = words.lastIndexOf("[", right);
            String repeatStr = words.substring(left+1, right);
            String[] split = repeatStr.split("\\|");
            words = words.replace("[" + repeatStr + "]",
                    String.join("", Collections.nCopies(Integer.parseInt(split[0]), split[1])));
        }
        return words;
    }
}

