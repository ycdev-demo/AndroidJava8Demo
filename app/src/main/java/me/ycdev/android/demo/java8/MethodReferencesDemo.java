package me.ycdev.android.demo.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MethodReferencesDemo {
    @FunctionalInterface
    public interface Transformer<F, T> {
        T transform(F obj);

        static void test() {
            // nothing to do
        }
    }

    public static class Person {
        public int age;
        public String name;

        public Person() {}

        private Person(int age) {
            this.age = age;
            this.name = "P-" + age;
        }

        public static Person convert(int age) {
            return new Person(age);
        }

        public int compareByAge(Person other) {
            return age - other.age;
        }

        @Override
        public String toString() {
            return "Person[name=" + name + ", age=" + age + "]";
        }
    }

    public static class MyComparator {
        public static int compare(Person lhs, Person rhs) {
            return lhs.age - rhs.age;
        }
    }

    public static <F, T> List<T> transform(List<F> list, Transformer<F, T> transformer) {
        ArrayList<T> result = new ArrayList<T>(list.size());
        for (F obj : list) {
            result.add(transformer.transform(obj));
        }
        return result;
    }

    public void showUsage() {
        staticMethod();
        instanceMethod();
        typeMethod();
        constructor();
    }

    private void staticMethod() {
        List<Integer> ageList = Arrays.asList(1, 2, 3, 4, 5);
        List<Person> personList = transform(ageList, Person::convert);
        System.out.println("staticMethod: ");
        System.out.println(Arrays.toString(personList.toArray()));
    }

    private Person createPerson(int age) {
        return Person.convert(age);
    }

    private void instanceMethod() {
        List<Integer> ageList = Arrays.asList(6, 7, 8, 9, 10);
        List<Person> personList = transform(ageList, this::createPerson);
        System.out.println("instanceMethod: ");
        System.out.println(Arrays.toString(personList.toArray()));
    }

    private void typeMethod() {
        List<Integer> ageList = Arrays.asList(1, 4, 2, 10, 6);
        List<Person> personList = transform(ageList, this::createPerson);
        Collections.sort(personList, Person::compareByAge);
        System.out.println("typeMethod: ");
        System.out.println(Arrays.toString(personList.toArray()));
    }

    private void constructor() {
        List<Integer> ageList = Arrays.asList(11, 21, 31, 41, 51);
        List<Person> personList = transform(ageList, Person::new);
        System.out.println("constructor: ");
        System.out.println(Arrays.toString(personList.toArray()));
    }
}
