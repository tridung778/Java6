package com.example.java6_lab1.app;

import com.example.java6_lab1.bean.Contact;
import com.example.java6_lab1.bean.Student2;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jackson2 {

    public static void main(String[] args) throws IOException {
//        demo1();
//        demo2();
//        demo3();
//        demo4();
//        demo5();
        demo6();
    }

    private static void demo1() throws IOException {
        String path = "src\\main\\resources\\student.json";

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> student = mapper.readValue(new File(path), Map.class);

        System.out.println(">> Name: " + student.get("name"));
        System.out.println(">> Gender: " + student.get("gender"));
        System.out.println(">> Marks: " + student.get("marks"));
        Map<String, Object> contact = (Map<String, Object>) student.get("contact");
        System.out.println(">> Phone: " + contact.get("phone"));
        System.out.println(">> Email: " + contact.get("email"));
        List<String> subjects = (List<String>) student.get("subject");
        subjects.forEach(subject -> {
            System.out.println(">> Subject: " + subject);
        });


    }

    private static void demo2() throws IOException {
        String path = "src\\main\\resources\\students.json";
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> students = mapper.readValue(new File(path), List.class);
        students.forEach(student -> {
            System.out.println(">> Name: " + student.get("name"));
        });
    }

    private static void demo3() throws IOException {
        String path = "src\\main\\resources\\student.json";

        ObjectMapper mapper = new ObjectMapper();
        Student2 student = mapper.readValue(new File(path), Student2.class);

        System.out.println(">> Name: " + student.getName());
        System.out.println(">> Gender: " + student.getGender());
        System.out.println(">> Marks: " + student.getGender());
        Contact contact = student.getContact();
        System.out.println(">> Phone: " + contact.getPhone());
        System.out.println(">> Email: " + contact.getEmail());
        List<String> subjects = student.getSubject();
        subjects.forEach(subject -> {
            System.out.println(">> Subject: " + subject);
        });
    }

    private static void demo4() throws IOException {
        String path = "src\\main\\resources\\students.json";
        TypeReference<List<Student2>> type = new TypeReference<>() {
        };
        ObjectMapper mapper = new ObjectMapper();
        List<Student2> students = mapper.readValue(new File(path), type);
        students.forEach(student -> {
            System.out.println(">> Name: " + student.getName());
        });
    }

    private static void demo5() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode student = mapper.createObjectNode();
        student.put("name", "Nguyễn Văn Tèo 4");
        student.put("gender", true);
        student.put("marks", 10);
        ObjectNode contact = student.putObject("contact");
        contact.put("phone", "0123456789");
        contact.put("email", "kQb5r@example.com");
        ObjectNode subject = contact.putObject("subject");
        subject.put("Java", "Java");
        subject.put("C++", "C++");
        subject.put("C#", "C#");
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);

        System.out.println(json);
        mapper.writeValue(new File("src\\main\\resources\\student2.json"), student);
    }

    private static void demo6() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> contact = new HashMap<>();
        contact.put("email", "pTJpE@example.com");
        contact.put("phone", "0123456789");

        Map<String, Object> student = new HashMap<>();
        student.put("name", "Nguyễn Văn Tèo 4");
        student.put("gender", true);
        student.put("marks", 10);
        student.put("contact", contact);
        student.put("subject", new String[]{"Java", "C++", "C#"});

        List<String> subjects = new ArrayList<>();
        subjects.add("Java");
        subjects.add("C++");
        subjects.add("C#");
        contact.put("subject", subjects);


        String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(student);
        System.out.println(json);
        mapper.writeValue(new File("src\\main\\resources\\student3.json"), student);
    }
}
