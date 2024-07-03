package com.example.java6_lab2.controllers;

import com.example.java6_lab2.beans.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    @RequestMapping("/student")
    public String student(Model model, @RequestParam("index") Optional<Integer> index) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String path = "src\\main\\resources\\static\\data\\students.json";

        TypeReference<List<Student>> typeReference = new TypeReference<>() {};

        List<Student> students = mapper.readValue(new File(path), typeReference);

        Student student = students.get(index.orElse(0));
        model.addAttribute("student", student);
        model.addAttribute("index", index.orElse(0));
        return "student";
    }

}
