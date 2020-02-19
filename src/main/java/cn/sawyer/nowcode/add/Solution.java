package cn.sawyer.nowcode.add;

/**
 * @program: LeetCode
 * @description: 不用加减乘除实现加法，https://www.nowcoder.com/practice/59ac416b4b944300b617d4f7f111b215?tpId=13&tqId=11201&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * @author: sawyer
 * @create: 2020-01-12 13:31
 **/

public class Solution {
    // 异或 ^ ==> 相加结果
    // 与 & ==> 进位结果

    public int add(int num1, int num2) {

        int ans;
        int result;
        do {
            result = num1 ^ num2;
            ans = (num1 & num2) << 1;
            num1 = result;
            num2 = ans;
        } while (ans != 0);


        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.add(5, 7));
    }
}
