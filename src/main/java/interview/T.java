package interview;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-02-29 12:55
 **/
public class T {

    public static void main(String[] args) {
        T a = new T();
        T b = new T();
        String s = "ab";
        Character c = 'a';
        System.out.println(c.hashCode());
        System.out.println(s.hashCode());
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }
}
