package interview.ali;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-03-13 16:54
 **/
public class Solution2 {

    public void analysisGCLog(File gcFile) throws FileNotFoundException{
        Scanner sc = new Scanner(gcFile);

        String lastLine = sc.nextLine();
        String currLine;
        double time = Double.parseDouble(lastLine.split("secs")[1].split(",")[1].substring(1));
        while (sc.hasNextLine()) {
            currLine = sc.nextLine();
            String currDateTime = currLine.substring(0, 17);
            String lastDateTime = lastLine.substring(0, 17);
            if (currDateTime.equals(lastDateTime)) {
                time += Double.parseDouble(currLine.split("secs")[1].split(",")[1].substring(1));
            } else {
                String dateInfo = lastDateTime.replaceAll("T", " ");
                System.out.println(String.format("%s ---> %.3f", dateInfo, time));
                time = Double.parseDouble(currLine.split("secs")[1].split(",")[1]);
            }
            lastLine = currLine;
        }
        sc.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Solution2 solution2 = new Solution2();
        File file = new File("haha.txt");
        System.out.println(file.exists());
        System.out.println(System.getProperty("user.dir"));
        solution2.analysisGCLog(new File("gc.txt"));
    }
}
