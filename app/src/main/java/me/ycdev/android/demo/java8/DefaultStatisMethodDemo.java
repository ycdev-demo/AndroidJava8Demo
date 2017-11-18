package me.ycdev.android.demo.java8;

class DefaultStatisMethodDemo {
    void showUsage() {
        ItsAnInterface it = () -> System.out.println("fun");
        ItsAnInterface.bar(it);
    }
}

@FunctionalInterface
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