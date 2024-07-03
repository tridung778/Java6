package com.example.java6_lab2.controllers;


import com.example.java6_lab2.beans.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;

@Controller
public class HomeController {

    @RequestMapping("/home/index")
    public String index(Model model) throws IOException {

        model.addAttribute("message", "Hello Thymeleaf!");

        ObjectMapper mapper = new ObjectMapper();
        String path = "src\\main\\resources\\static\\data\\student.json";
        Student student = mapper.readValue(new File(path), Student.class);
        model.addAttribute("student", student);

        return "/home/index";
    }
}
