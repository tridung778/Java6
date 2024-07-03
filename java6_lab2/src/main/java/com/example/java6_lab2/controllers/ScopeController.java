package com.example.java6_lab2.controllers;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ScopeController {

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession session;

    @Autowired
    ServletContext context;

    @RequestMapping("/scope")
    public String hello(Model model) {
        model.addAttribute("model", "I am a Model");
        request.setAttribute("request", "I am a request");
        session.setAttribute("session", "I am a session");
        context.setAttribute("context", "I am a context");
        return "scope";
    }

}
