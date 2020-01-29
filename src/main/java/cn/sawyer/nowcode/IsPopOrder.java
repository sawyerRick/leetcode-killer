package cn.sawyer.nowcode;

import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 栈的压入，弹出，https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author: sawyer
 * @create: 2020-01-10 16:23
 **/
public class IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int len = pushA.length;
        Stack<Integer> s = new Stack<>();

        for(int i=0, j=0;  i < len; i++){
            s.push(pushA[i]);
            System.out.println("peek:" + s.peek());
            while(j < len && s.peek() == popA[j]){
                int n = s.pop();
                System.out.println(n);
                j = j+1;
            }
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        IsPopOrder isPopOrder = new IsPopOrder();
        isPopOrder.IsPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
    }
}
