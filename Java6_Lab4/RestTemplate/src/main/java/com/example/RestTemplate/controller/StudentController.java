package com.example.RestTemplate.controller;

import com.example.RestTemplate.DAO.StudentDAO;
import com.example.RestTemplate.bean.StudentMap;
import com.example.RestTemplate.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentDAO studentDAO;

    @RequestMapping("/student/index")
    public String index(Model model) {
        Student student = new Student("", "", 0.0, true, "VN");
        model.addAttribute("student", student);
        StudentMap studentMap = studentDAO.findALl();
        model.addAttribute("students", studentMap);
        return "student/index";
    }

    @RequestMapping("/student/edit/{key}")
    public String edit(Model model, @PathVariable("key") String key) {
        model.addAttribute("key", key);
        Student student = studentDAO.findByKey(key);
        model.addAttribute("student", student);
        StudentMap studentMap = studentDAO.findALl();
        model.addAttribute("students", studentMap);
        return "student/index";
    }

    @RequestMapping("/student/create")
    public String create(Model model, Student student) {
        studentDAO.create(student);
        return "redirect:/student/index";
    }

    @RequestMapping("/student/delete/{key}")
    public String delete(@PathVariable("key") String key) {
        studentDAO.delete(key);
        return "redirect:/student/index";
    }

    @RequestMapping("/student/update/{key}")
    public String update(Student student, @PathVariable("key") String key) {
        studentDAO.update(student, key);
        return "redirect:/student/index";
    }
}
