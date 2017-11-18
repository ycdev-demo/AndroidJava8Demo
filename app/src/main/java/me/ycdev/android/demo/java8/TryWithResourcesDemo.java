package me.ycdev.android.demo.java8;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.Closeable;

class TryWithResourcesDemo {
    static class MyResource1 implements Closeable {
        void use() {
            System.out.println("MyResource1#use()");
        }

        @Override
        public void close() {
            System.out.println("MyResource1#close()");
        }
    }

    static class MyResource2 implements Closeable {
        void use() {
            System.out.println("MyResource2#use()");
        }

        @Override
        public void close() {
            System.out.println("MyResource2#close()");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    static class MyResource3 implements AutoCloseable {
        void use() {
            System.out.println("MyResource3#use()");
        }

        @Override
        public void close() {
            System.out.println("MyResource3#close()");
        }
    }

    void showUsage() {
        System.out.println("TryWithResourcesDemo#showUsage() BEGIN");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            try (MyResource1 res1 = new MyResource1();
                 MyResource2 res2 = new MyResource2();
                 MyResource3 res3 = new MyResource3()) {
                res1.use();
                res2.use();
                res3.use();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try (MyResource1 res1 = new MyResource1();
                 MyResource2 res2 = new MyResource2()) {
                res1.use();
                res2.use();
            }
        }
        System.out.println("TryWithResourcesDemo#showUsage() END");
    }
}
