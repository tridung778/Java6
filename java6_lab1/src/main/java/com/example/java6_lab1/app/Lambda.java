package com.example.java6_lab1.app;

import com.example.java6_lab1.bean.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lambda {

    static List<Student> list = Arrays.asList(
            new Student("Nguyễn Văn Tèo", false, 7.5),
            new Student("Le Thi Phi Phi", true, 8.5),
            new Student("Nguyễn Thi Kích", true, 9.0),
            new Student("Phúc Thanh Nhi", false, 6.5),
            new Student("Nguyễn Thếnh Nhi", false, 4.5)
    );

    public static void main(String[] args) {
//        demo1();
//        demo2();
//        demo3();
        demo4();
    }


    private static void demo1() {
        List<Integer> list = Arrays.asList(1, 9, 4, 7, 5, 2);
        list.forEach(System.out::println);
    }

    private static void demo2() {
        printAllStudent(list);
    }

    private static void demo3() {
        Collections.sort(list, (sv1, sv2) -> -sv1.getMarks().compareTo(sv2.getMarks()));
        printAllStudent(list);
    }

    private static void demo4() {
        IDemo4Interface demo4Interface = System.out::println;
        demo4Interface.m1(5);
    }

    static void printAllStudent(List<Student> list) {
        list.forEach(sv -> {
            System.out.println("Ho ten: " + sv.getName());
            if (sv.getGender()) {
                System.out.println("Gioi tinh: Nu");
            } else {
                System.out.println("Gioi tinh: Nam");
            }
            System.out.println("Diem : " + sv.getMarks());
            System.out.println("-------------------------------");
        });
    }

}

@FunctionalInterface
interface IDemo4Interface {
    void m1(int x);

    default void m2() {
    }

    ;

    public static void m3() {
    }
}
