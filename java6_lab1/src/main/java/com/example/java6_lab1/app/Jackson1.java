package com.example.java6_lab1.app;

import com.example.java6_lab1.bean.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Jackson1 {

    public static void main(String[] args) throws IOException {
//        demo1();
        demo2();
//        demo3();
//        demo4();
    }

    private static void demo1() throws IOException {
        String path = "src\\main\\resources\\student.json";


        ObjectMapper mapper = new ObjectMapper();
        JsonNode student = mapper.readTree(new File(path));

        System.out.println(">> Name: " + student.get("name").asText());

        if (student.get("gender").asBoolean()) {
            System.out.println(">> Gender: Nam");
        } else {
            System.out.println(">> Gender: Nu");
        }

        System.out.println(">> Marks: " + student.get("marks").asDouble());
        System.out.println(">> Phone: " + student.get("contact").get("phone").asText());
        System.out.println(">> Email: " + student.get("contact").get("email").asText());
        student.get("subject").forEach(System.out::println);
    }

    private static void demo2() {
        String path = "src\\main\\resources\\students.json";

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode students = mapper.readTree(new File(path));
          students.iterator().forEachRemaining(st->{
              System.out.println(">> Name: " + st.get("name").asText());
          });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void demo3() {
        // TODO Auto-generated method stub
    }

    private static void demo4() {
        // TODO Auto-generated method stub
    }
}
