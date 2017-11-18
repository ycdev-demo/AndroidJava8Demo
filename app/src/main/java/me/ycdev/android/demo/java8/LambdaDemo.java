package me.ycdev.android.demo.java8;

class LambdaDemo {
    @FunctionalInterface
    interface OperatorTypeOne {
        int operate(int value);
    }

    //@FunctionalInterface
    interface OperatorTypeTwoInt {
        int operate(int lhs, int rhg);
    }

    interface OperatorTypeTwoLong {
        long operate(long lhs, long rhg);
    }

    void showUsage() {
        executeTask(() -> System.out.println("Hello, world #1"));
        executeTask(() -> {
            System.out.print("Hello,");
            System.out.println("world #2");
        });

        executeTask(a -> a * 2, 10);
        executeTask(a -> a * 2, 20);

        executeTask((int lhs, int rhs) -> lhs + rhs, 2, 5);
        executeTask((int lhs, int rhs) -> lhs + rhs, 5, 7);

        executeTask((long lhs, long rhs) -> lhs * rhs, 3, 6);
        executeTask((long lhs, long rhs) -> lhs * rhs, 6, 3);
    }

    private void executeTask(Runnable task) {
        task.run();
    }

    private void executeTask(OperatorTypeOne operator, int value) {
        System.out.println("operatorOne: " + operator.operate(value));
    }

    private void executeTask(OperatorTypeTwoInt operator, int value1, int value2) {
        System.out.println("operatorTwoInt: " + operator.operate(value1, value2));
    }

    private void executeTask(OperatorTypeTwoLong operator, long value1, long value2) {
        System.out.println("operatorTwoLong: " + operator.operate(value1, value2));
    }
}
