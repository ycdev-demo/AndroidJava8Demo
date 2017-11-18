package me.ycdev.android.demo.java8n;

import java.util.ArrayList;
import java.util.List;

class StreamDemo {
    static class Student {
        String name;
        int age;
        double weight;
        int height;

        Student(String name, int age, double weight, int height) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Student[name=" + name + ", age=" + age + ", weight=" + weight
                    + ", height=" + height + "]";
        }
    }

    void showUsage() {
        generateDate().stream()
                .filter(s -> s.age >= 16 && s.age <= 17)
                .map(s -> {
                    s.name = s.name.toLowerCase();
                    return s;
                })
                .sorted((lhs, rhs) -> {
                    int result = lhs.age - rhs.age;
                    if (result != 0) {
                        return result;
                    } else {
                        return rhs.name.compareTo(lhs.name);
                    }
                })
                .forEach(System.out::println);
    }

    private List<Student> generateDate() {
        List<Student> results = new ArrayList<>();
        results.add(new Student("S1", 16, 40.5, 158));
        results.add(new Student("S2", 18, 50, 165));
        results.add(new Student("S3", 17, 43.3, 160));
        results.add(new Student("S4", 16, 42.7, 157));
        results.add(new Student("S5", 15, 45, 163));
        results.add(new Student("S6", 17, 55, 175));
        results.add(new Student("S7", 16, 57, 178));
        results.add(new Student("S8", 15, 48, 167));
        return results;
    }
}
