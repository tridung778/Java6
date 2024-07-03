package com.example.java6_lab2.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "FPT <b>Polytechnic</b>");
        return "hello";
    }
}
