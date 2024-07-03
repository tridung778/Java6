package com.example.java6_lab3.controllers;

import com.example.java6_lab3.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class StudentController {
    @GetMapping("/student/form")
    public String getForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "student/form";
    }

    @PostMapping("/student/save")
    public String postForm(@ModelAttribute("student") Student student, Model model) {
        model.addAttribute("student", student);
        return "student/saved";
    }
}
