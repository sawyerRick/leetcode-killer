package cn.sawyer.leetcode.KMP;

/**
 * @program: LeetCode
 * @description: 实现strStr()， https://leetcode-cn.com/problems/implement-strstr/
 * @author: sawyer
 * @create: 2020-01-09 18:23
 **/
public class Solution {

    // 暴力搜索
    public int strStr(String haystack, String needle) {
        if ((haystack == null || haystack.length() == 0) || (needle == null || needle.length() == 0)) {
            return 0;
        }

        int n = haystack.length();
        int m = needle.length();


        for (int i = 0; i < n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.strStr2("abaaaacdefaaasdflaksjdflkajdf", "ab");
        System.out.println("i = " + i);
    }

    // KMP
    public int strStr2(String haystack, String needle) {
        // 最长公共前后缀表（表示了状态的转移）
        int[] prefixTable = new int[needle.length()];
        prefixTable(needle, prefixTable);

        int stat = prefixTable[0]; // 当前状态
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) != needle.charAt(stat)) {
                stat = prefixTable[stat];
            } else {
                stat++;
                if (stat + 1 == needle.length()) {
                    return i;
                }
            }
        }

        return -1;
    }

    void prefixTable(String pattern, int[] prefix) {
        prefix[0] = 0;
        int len = 0; //公共前后缀长度
        int i = 1;

        while (i < pattern.length()) {
            // 后缀加上下一个字符与前缀加上一个字符匹配
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                prefix[i] = len;
                i++;
            } else {
                // 不匹配则退回前一个
                if (len > 0) {
                    len = prefix[len - 1];
                } else {
                    prefix[len] = 0;
                    i++;
                }
            }
        }
    }
}
