package cn.sawyer.nowcodeExam;

/**
 * @program: LeetCode
 * @description:
 * @author: sawyer
 * @create: 2020-01-05 17:25
 **/
public class Main {
    public static void main(String[] args) {
        // 父类调用的是子类的callName, 所以是NUll
        B b = new B();
    }
}

class A {
    private String name = "A";

    public A() {
        callName();
    }

    public void callName() {
        System.out.println(name);
    }
}

class B extends A{
    private String name = "B";

//    public B() {
//        b();
//    }

    public void callName() {
        System.out.println(name);
    }
}

class Base
{
    private String baseName = "base";
    public Base()
    {
        callName();
    }

    public void callName()
    {
        System. out. println(baseName);
    }

    static class Sub extends Base
    {
        private String baseName = "sub";
        public void callName()
        {
            System. out. println (baseName) ;
        }
    }
    public static void main(String[] args)
    {
        Base b = new Sub();
    }
}
