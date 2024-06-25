package com.example.java6_lab1.app;

import com.example.java6_lab1.bean.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.java6_lab1.app.Lambda.printAllStudent;

public class StreamAPI {

    static List<Student> list = Arrays.asList(
            new Student("Nguyễn Văn Tèo", false, 7.5),
            new Student("Le Thi Phi Phi", true, 8.5),
            new Student("Nguyễn Thi Kích", true, 9.0),
            new Student("Phúc Thanh Nhi", false, 6.5),
            new Student("Nguyễn Thếnh Nhi", false, 5.5)
    );

    public static void main(String[] args) {
//        demo1();
//        demo2();
//        demo3();
        demo4();
    }

    private static void demo1() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        stream.forEach(System.out::println);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.stream().forEach(System.out::println);

    }

    private static void demo2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Double> result = list.stream()
                .filter(n -> n % 2 == 0)
                .map(Math::sqrt)
                .peek(System.out::println)
                .collect(Collectors.toList());

    }

    private static void demo3() {
        List<Student> result = list.stream()
                .filter(s -> s.getMarks() >= 7)
                .peek(sv -> sv.setName(sv.getName().toUpperCase()))
                .collect(Collectors.toList());

        printAllStudent(result);
    }

    private static void demo4() {
        double avg = list.stream()
                .mapToDouble(Student::getMarks)
                .average()
                .getAsDouble();
        System.out.println("avg " + avg);

        double sum = list.stream()
                .mapToDouble(Student::getMarks)
                .sum();
        System.out.println("sum " + sum);

        double min = list.stream()
                .mapToDouble(Student::getMarks)
                .min()
                .getAsDouble();
        System.out.println("min " + min);

        boolean all_passed = list.stream()
                .allMatch(s -> s.getMarks() >= 5);
        System.out.println("all_passed " + all_passed);

        Student min_sv = list.stream()
                .reduce(list.get(0), (s1, s2) -> s1.getMarks() < s2.getMarks() ? s1 : s2);
        System.out.println("min_sv " + min_sv.getName());
    }


}
