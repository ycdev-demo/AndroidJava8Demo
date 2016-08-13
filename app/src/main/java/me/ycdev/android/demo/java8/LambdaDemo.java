package me.ycdev.android.demo.java8;

public class LambdaDemo {
    @FunctionalInterface
    interface OperatorTypeOne {
        int operate(int value);
    }

    interface OperatorTypeTwoInt {
        int operate(int lhs, int rhg);
    }

    interface OperatorTypeTwoLong {
        long operate(long lhs, long rhg);
    }

    public void showUsage() {
        executeTask(() -> System.out.println("Hello, world #1"));
        executeTask(() -> {
            System.out.print("Hello,");
            System.out.println("world #2");
        });

        executeTask(a -> a * 2);

        executeTask((int lhs, int rhs) -> lhs + rhs);

        executeTask((long lhs, long rhs) -> lhs * rhs);
    }

    private void executeTask(Runnable task) {
        task.run();
    }

    private void executeTask(OperatorTypeOne operator) {
        System.out.println("operatorOne: " + operator.operate(10));
    }

    private void executeTask(OperatorTypeTwoInt operator) {
        System.out.println("operatorTwoInt: " + operator.operate(2, 5));
    }

    private void executeTask(OperatorTypeTwoLong operator) {
        System.out.println("operatorTwoLong: " + operator.operate(2, 5));
    }
}
