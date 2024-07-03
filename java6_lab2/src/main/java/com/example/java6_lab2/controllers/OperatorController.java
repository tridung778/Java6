package com.example.java6_lab2.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OperatorController {

    @GetMapping("/operator")
    public String operator(Model model) {
        model.addAttribute("x", 5);
        model.addAttribute("y", 2);
        return "operator";
    }

}
