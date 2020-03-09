package cn.sawyer.leetcode.numUniqueEmails;

import java.util.HashSet;

/**
 * @program: LeetCode
 * @description: 独特的电子邮件地址，https://leetcode-cn.com/problems/unique-email-addresses/
 * @author: sawyer
 * @create: 2020-02-21 23:09
 **/
public class Solution {
    public int numUniqueEmails(String[] emails) {
        if (emails.length == 0) {
            return 0;
        }

        HashSet<String> set = new HashSet<>();

        for (String x : emails) {
            String local = x.split("@")[0];
            String domain = x.split("@")[1];

            local = local.replaceAll("\\.", "");
            int addIdx = local.indexOf("+");
            if (addIdx != -1) {
                local = local.substring(0, addIdx);
            }
            set.add(local + "@" + domain);
        }

        return set.size();
    }
}