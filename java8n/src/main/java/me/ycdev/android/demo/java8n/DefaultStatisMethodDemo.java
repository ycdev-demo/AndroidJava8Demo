package me.ycdev.android.demo.java8n;

public class DefaultStatisMethodDemo {
    public void showUsage() {
        ItsAnInterface it = () -> System.out.println("fun");
        ItsAnInterface.bar(it);
    }
}

interface ItsAnInterface {
    void fun();

    default void foo() {
        System.out.println("foo");
    }

    static void bar(ItsAnInterface a) {
        System.out.println("bar");
        a.fun();
        a.foo();
    }
}