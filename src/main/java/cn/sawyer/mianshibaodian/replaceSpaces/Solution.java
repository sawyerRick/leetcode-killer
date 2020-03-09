package cn.sawyer.mianshibaodian.replaceSpaces;

/**
 * @program: LeetCode
 * @description: URL化，https://leetcode-cn.com/problems/string-to-url-lcci/
 * @author: sawyer
 * @create: 2020-03-05 16:02
 **/
public class Solution {
    public String replaceSpaces(String S, int length) {


        return S.substring(0, length).replaceAll(" ", "%20");
    }

    public String replaceSpaces2(String S, int length) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++){
            if(S.charAt(i) == ' '){
                sb.append("%20");
            }else{
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
}