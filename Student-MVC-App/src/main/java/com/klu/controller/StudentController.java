package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Student;
import com.klu.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService service;

    // Welcome
    @GetMapping("/greet")
    public String getWelcomeMessage() {
        return service.getWelcomeMessage();
    }

    // Create
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    // Get All
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // Get By ID
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    // Update
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable int id,
                                 @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    // Delete
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        return service.deleteStudent(id);
    }

    // Search
    @GetMapping("/students/search")
    public List<Student> searchStudent(@RequestParam String name,
                                       @RequestParam String course) {
        return service.searchStudent(name, course);
    }
}
