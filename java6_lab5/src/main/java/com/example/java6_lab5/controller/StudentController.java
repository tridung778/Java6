package com.example.java6_lab5.controller;

import com.example.java6_lab5.model.Student;
import com.example.java6_lab5.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{email}")
    public Student getStudentByEmail(@PathVariable("email") String email) {
        return studentRepository.findById(email).get();
    }

    @PostMapping("")
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @DeleteMapping("/{email}")
    public void deleteStudent(@PathVariable("email") String email) {
        studentRepository.deleteById(email);
    }

    @PutMapping("/{email}")
    public Student updateStudent(@PathVariable("email") String email, @RequestBody Student student) {
        return studentRepository.save(student);
    }
}
