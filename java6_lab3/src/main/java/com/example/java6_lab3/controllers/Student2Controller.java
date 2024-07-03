package com.example.java6_lab3.controllers;

import com.example.java6_lab3.models.Student;
import com.example.java6_lab3.models.Student2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Student2Controller {
    @GetMapping("/student2/form")
    public String getForm(Model model) {
        Student2 student = new Student2();
        model.addAttribute("student", student);
        return "student/form2";
    }

    @PostMapping("/student2/save")
    public String postForm(@Validated @ModelAttribute("student") Student2 student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/form2";
        } else {
            model.addAttribute("student", student);
            return "student/saved";
        }
    }
}
